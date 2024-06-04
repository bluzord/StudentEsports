package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.FreePlayerDTO;
import com.studentesports.backend.DTO.TeamComposition;
import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.exceptions.TeamsNotFoundException;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.players.Player;
import com.studentesports.backend.models.Team;
import com.studentesports.backend.respositories.PlayerRepository;
import com.studentesports.backend.respositories.TeamRepository;
import com.studentesports.backend.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamRepository.findAll();
        if (teams.isEmpty()) throw new TeamsNotFoundException("Команды не найдены");
        return teams.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Team createTeam(MultipartFile logo, String name, String game) throws IOException {
        String filePath = "C:/Users/bluzord/Documents/StudentEsports/frontend/src/app/images/team-logo/" + logo.getOriginalFilename();
        Team team = new Team(name, game, logo.getOriginalFilename());
        logo.transferTo(new File(filePath));
        teamRepository.save(team);
        return team;
    }

    @Override
    public TeamComposition getTeamForEdit(int id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamsNotFoundException("Команда не найдена"));
        TeamComposition result = new TeamComposition();
        result.setId(team.getId());
        result.setName(team.getName());
        result.setGame(team.getGame());
        result.setPlayers(team.getPlayers().stream().map(this::mapToFreePlayer).collect(Collectors.toList()));
        return result;
    }

    @Override
    public void updateTeamPlayers(TeamComposition team) {
        Team currentTeam = teamRepository.findById(team.getId()).orElseThrow(() -> new TeamsNotFoundException("Команда не найдена"));
        List<FreePlayerDTO> currentPlayers = currentTeam.getPlayers().stream().map(this::mapToFreePlayer).toList();
        for (FreePlayerDTO player : currentPlayers) {
           if (!team.getPlayers().contains(player)) {
               Player playerToRemove = playerRepository.findById(player.getId()).orElseThrow();
               playerToRemove.setTeam(null);
               playerRepository.save(playerToRemove);
           }
        }
        for (FreePlayerDTO player : team.getPlayers()) {
            if (!currentPlayers.contains(player)) {
                Player playerToAdd = playerRepository.findById(player.getId()).orElseThrow();
                playerToAdd.setTeam(currentTeam);
                playerRepository.save(playerToAdd);
            }
        }
        teamRepository.save(currentTeam);
    }

    private FreePlayerDTO mapToFreePlayer(Player player) {
        FreePlayerDTO playerDTO = new FreePlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setNickname(player.getNickname());
        return playerDTO;
    }

    private TeamDTO mapToDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setGame(team.getGame());

        List<String> players = team.getPlayers().stream().map(Player::getNickname).toList();

        int i;
        for (i = 0; i < players.size(); i++) {
            if (team.getCaptain() != null) {
                if (Objects.equals(players.get(i), team.getCaptain().getNickname())) break;
            }

        }

        teamDTO.setCaptainIndex(i);
        teamDTO.setPlayers(players);
        teamDTO.setLogo(team.getLogo());

        return teamDTO;
    }
}
