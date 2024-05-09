package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.models.Player;
import com.studentesports.backend.models.Team;
import com.studentesports.backend.respositories.PlayerRepository;
import com.studentesports.backend.respositories.TeamRepository;
import com.studentesports.backend.services.PlayerService;
import com.studentesports.backend.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private TeamDTO mapToDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setGame(team.getGame());

        List<String> players = team.getPlayers().stream().map(Player::getNickname).toList();
        int i;
        for (i = 0; i < players.size(); i++) {
            if (Objects.equals(players.get(i), team.getCaptain().getNickname())) break;
        }

        teamDTO.setCaptainIndex(i);
        teamDTO.setPlayers(players);
        teamDTO.setLogo(team.getLogo());

        return teamDTO;
    }
}
