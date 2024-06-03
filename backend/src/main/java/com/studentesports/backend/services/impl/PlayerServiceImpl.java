package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.exceptions.ApplicationsNotFoundException;
import com.studentesports.backend.exceptions.PlayersNotFoundException;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.models.players.*;
import com.studentesports.backend.respositories.PlayerRepository;
import com.studentesports.backend.respositories.players.*;
import com.studentesports.backend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerCS2Repository playerCS2Repository;
    private final PlayerDOTARepository playerDOTARepository;
    private final PlayerLOLRepository playerLOLRepository;
    private final PlayerSCRepository playerSCRepository;
    private final PlayerTEKKENRepository playerTEKKENRepository;
    private final PlayerVLRRepository playerVLRRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerCS2Repository playerCS2Repository, PlayerDOTARepository playerDOTARepository, PlayerLOLRepository playerLOLRepository, PlayerSCRepository playerSCRepository, PlayerTEKKENRepository playerTEKKENRepository, PlayerVLRRepository playerVLRRepository) {
        this.playerRepository = playerRepository;
        this.playerCS2Repository = playerCS2Repository;
        this.playerDOTARepository = playerDOTARepository;
        this.playerLOLRepository = playerLOLRepository;
        this.playerSCRepository = playerSCRepository;
        this.playerTEKKENRepository = playerTEKKENRepository;
        this.playerVLRRepository = playerVLRRepository;
    }

    @Override
    public List<PlayerDTO> getPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return players.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void createPlayerCS2(ApplicationCS2 application) {
        PlayerCS2 player = new PlayerCS2(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getSteamURL(),
                application.getFaceitELO(),
                application.getFaceitURL()
        );
        playerCS2Repository.save(player);
    }

    @Override
    public void createPlayerDOTA(ApplicationDOTA application) {
        PlayerDOTA player = new PlayerDOTA(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getSteamURL(),
                application.getDotaMMR(),
                application.getDotaPos(),
                application.getDotaBuff()
        );
        playerDOTARepository.save(player);
    }

    @Override
    public void createPlayerLOL(ApplicationLOL application) {
        PlayerLOL player = new PlayerLOL(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getRiotID(),
                application.getLolPos(),
                application.getLolRank()
        );
        playerLOLRepository.save(player);
    }

    @Override
    public void createPlayerVLR(ApplicationVLR application) {
        PlayerVLR player = new PlayerVLR(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getRiotID(),
                application.getVlrRole(),
                application.getVlrRank()
        );
        playerVLRRepository.save(player);
    }

    @Override
    public void createPlayerTEKKEN(ApplicationTEKKEN application) {
        PlayerTEKKEN player = new PlayerTEKKEN(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getTekkenRank()
        );
        playerTEKKENRepository.save(player);
    }

    @Override
    public void createPlayerSC(ApplicationSC application) {
        PlayerSC player = new PlayerSC(
                application.getName(),
                application.getSurname(),
                application.getPatronymic(),
                application.getNickname(),
                application.getVk(),
                application.getGame(),
                application.getScLeague(),
                application.getScAPM()
        );
        playerSCRepository.save(player);
    }

    @Override
    public List<PlayerCS2> getPlayersCS2() {
        List<PlayerCS2> playerCS2List = playerCS2Repository.findAll();
        if (playerCS2List.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerCS2List;
    }

    @Override
    public List<PlayerDOTA> getPlayersDOTA() {
        List<PlayerDOTA> playerDOTAList = playerDOTARepository.findAll();
        if (playerDOTAList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerDOTAList;
    }

    @Override
    public List<PlayerLOL> getPlayersLOL() {
        List<PlayerLOL> playerLOLList = playerLOLRepository.findAll();
        if (playerLOLList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerLOLList;
    }

    @Override
    public List<PlayerVLR> getPlayersVLR() {
        List<PlayerVLR> playerVLRList = playerVLRRepository.findAll();
        if (playerVLRList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerVLRList;
    }

    @Override
    public List<PlayerTEKKEN> getPlayersTEKKEN() {
        List<PlayerTEKKEN> playerTEKKENList = playerTEKKENRepository.findAll();
        if (playerTEKKENList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerTEKKENList;
    }

    @Override
    public List<PlayerSC> getPlayersSC() {
        List<PlayerSC> playerSCList = playerSCRepository.findAll();
        if (playerSCList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerSCList;
    }

    @Override
    public List<PlayerCS2> getFreePlayersCS2() {
        List<PlayerCS2> playerCS2List = playerCS2Repository.findAll();
        List<PlayerCS2> result = new ArrayList<>();
        for (PlayerCS2 player : playerCS2List) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<PlayerDOTA> getFreePlayersDOTA() {
        List<PlayerDOTA> playerDOTAList = playerDOTARepository.findAll();
        List<PlayerDOTA> result = new ArrayList<>();
        for (PlayerDOTA player : playerDOTAList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<PlayerLOL> getFreePlayersLOL() {
        List<PlayerLOL> playerLOLList = playerLOLRepository.findAll();
        List<PlayerLOL> result = new ArrayList<>();
        for (PlayerLOL player : playerLOLList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<PlayerVLR> getFreePlayersVLR() {
        List<PlayerVLR> playerVLRList = playerVLRRepository.findAll();
        List<PlayerVLR> result = new ArrayList<>();
        for (PlayerVLR player : playerVLRList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<PlayerTEKKEN> getFreePlayersTEKKEN() {
        List<PlayerTEKKEN> playerTEKKENList = playerTEKKENRepository.findAll();
        List<PlayerTEKKEN> result = new ArrayList<>();
        for (PlayerTEKKEN player : playerTEKKENList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<PlayerSC> getFreePlayersSC() {
        List<PlayerSC> playerSCList = playerSCRepository.findAll();
        List<PlayerSC> result = new ArrayList<>();
        for (PlayerSC player : playerSCList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result;
    }

    private PlayerDTO mapToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setSurname(player.getSurname());
        playerDTO.setNickname(player.getNickname());
        playerDTO.setGame(player.getGame());
        if (player.getTeam() == null) {
            playerDTO.setTeam("Нет команды");
        }
        else {
            playerDTO.setTeam(player.getTeam().getName());
        }
        playerDTO.setAvatar(player.getAvatar());
        return playerDTO;
    }
}
