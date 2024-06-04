package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.FreePlayerDTO;
import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.DTO.playersGAME.*;
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
    public List<PlayerCS2DTO> getPlayersCS2() {
        List<PlayerCS2> playerCS2List = playerCS2Repository.findAll();
        if (playerCS2List.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerCS2List.stream().map(this::mapCS2ToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlayerDOTADTO> getPlayersDOTA() {
        List<PlayerDOTA> playerDOTAList = playerDOTARepository.findAll();
        if (playerDOTAList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerDOTAList.stream().map(this::mapDOTAToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlayerLOLDTO> getPlayersLOL() {
        List<PlayerLOL> playerLOLList = playerLOLRepository.findAll();
        if (playerLOLList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerLOLList.stream().map(this::mapLOLToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlayerVLRDTO> getPlayersVLR() {
        List<PlayerVLR> playerVLRList = playerVLRRepository.findAll();
        if (playerVLRList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerVLRList.stream().map(this::mapVLRToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlayerTEKKENDTO> getPlayersTEKKEN() {
        List<PlayerTEKKEN> playerTEKKENList = playerTEKKENRepository.findAll();
        if (playerTEKKENList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerTEKKENList.stream().map(this::mapTEKKENToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlayerSCDTO> getPlayersSC() {
        List<PlayerSC> playerSCList = playerSCRepository.findAll();
        if (playerSCList.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return playerSCList.stream().map(this::mapSCToDTO).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersCS2() {
        List<PlayerCS2> playerCS2List = playerCS2Repository.findAll();
        List<PlayerCS2> result = new ArrayList<>();
        for (PlayerCS2 player : playerCS2List) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersDOTA() {
        List<PlayerDOTA> playerDOTAList = playerDOTARepository.findAll();
        List<PlayerDOTA> result = new ArrayList<>();
        for (PlayerDOTA player : playerDOTAList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersLOL() {
        List<PlayerLOL> playerLOLList = playerLOLRepository.findAll();
        List<PlayerLOL> result = new ArrayList<>();
        for (PlayerLOL player : playerLOLList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersVLR() {
        List<PlayerVLR> playerVLRList = playerVLRRepository.findAll();
        List<PlayerVLR> result = new ArrayList<>();
        for (PlayerVLR player : playerVLRList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersTEKKEN() {
        List<PlayerTEKKEN> playerTEKKENList = playerTEKKENRepository.findAll();
        List<PlayerTEKKEN> result = new ArrayList<>();
        for (PlayerTEKKEN player : playerTEKKENList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    @Override
    public List<FreePlayerDTO> getFreePlayersSC() {
        List<PlayerSC> playerSCList = playerSCRepository.findAll();
        List<PlayerSC> result = new ArrayList<>();
        for (PlayerSC player : playerSCList) {
            if (player.getTeam() == null) {
                result.add(player);
            }
        }
        return result.stream().map(this::mapToFreePlayer).collect(Collectors.toList());
    }

    private PlayerCS2DTO mapCS2ToDTO(PlayerCS2 player) {
        PlayerCS2DTO playerCS2DTO = new PlayerCS2DTO();
        playerCS2DTO.setId(player.getId());
        playerCS2DTO.setName(player.getName());
        playerCS2DTO.setSurname(player.getSurname());
        playerCS2DTO.setPatronymic(player.getPatronymic());
        playerCS2DTO.setVk(player.getVk());
        playerCS2DTO.setNickname(player.getNickname());
        playerCS2DTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerCS2DTO.setTeam(player.getTeam().getName());
            playerCS2DTO.setTeamId(player.getTeam().getId());
        }
        playerCS2DTO.setSteamURL(player.getSteamURL());
        playerCS2DTO.setFaceitELO(player.getFaceitELO());
        playerCS2DTO.setFaceitURL(player.getFaceitURL());
        return playerCS2DTO;
    }

    private PlayerDOTADTO mapDOTAToDTO(PlayerDOTA player) {
        PlayerDOTADTO playerDOTADTO = new PlayerDOTADTO();
        playerDOTADTO.setId(player.getId());
        playerDOTADTO.setName(player.getName());
        playerDOTADTO.setSurname(player.getSurname());
        playerDOTADTO.setPatronymic(player.getPatronymic());
        playerDOTADTO.setVk(player.getVk());
        playerDOTADTO.setNickname(player.getNickname());
        playerDOTADTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerDOTADTO.setTeam(player.getTeam().getName());
            playerDOTADTO.setTeamId(player.getTeam().getId());
        }
        playerDOTADTO.setSteamURL(player.getSteamURL());
        playerDOTADTO.setDotaPos(player.getDotaPos());
        playerDOTADTO.setDotaMMR(player.getDotaMMR());
        playerDOTADTO.setDotaBuff(player.getDotaBuff());
        return playerDOTADTO;
    }

    private PlayerLOLDTO mapLOLToDTO(PlayerLOL player) {
        PlayerLOLDTO playerLOLDTO = new PlayerLOLDTO();
        playerLOLDTO.setId(player.getId());
        playerLOLDTO.setName(player.getName());
        playerLOLDTO.setSurname(player.getSurname());
        playerLOLDTO.setPatronymic(player.getPatronymic());
        playerLOLDTO.setVk(player.getVk());
        playerLOLDTO.setNickname(player.getNickname());
        playerLOLDTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerLOLDTO.setTeam(player.getTeam().getName());
            playerLOLDTO.setTeamId(player.getTeam().getId());
        }
        playerLOLDTO.setRiotID(player.getRiotID());
        playerLOLDTO.setLolPos(player.getLolPos());
        playerLOLDTO.setLolRank(player.getLolRank());
        return playerLOLDTO;
    }

    private PlayerVLRDTO mapVLRToDTO(PlayerVLR player) {
        PlayerVLRDTO playerVLRDTO = new PlayerVLRDTO();
        playerVLRDTO.setId(player.getId());
        playerVLRDTO.setName(player.getName());
        playerVLRDTO.setSurname(player.getSurname());
        playerVLRDTO.setPatronymic(player.getPatronymic());
        playerVLRDTO.setVk(player.getVk());
        playerVLRDTO.setNickname(player.getNickname());
        playerVLRDTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerVLRDTO.setTeam(player.getTeam().getName());
            playerVLRDTO.setTeamId(player.getTeam().getId());
        }
        playerVLRDTO.setRiotID(player.getRiotID());
        playerVLRDTO.setVlrRank(player.getVlrRank());
        playerVLRDTO.setVlrRole(player.getVlrRole());
        return playerVLRDTO;
    }

    private PlayerSCDTO mapSCToDTO(PlayerSC player) {
        PlayerSCDTO playerSCDTO = new PlayerSCDTO();
        playerSCDTO.setId(player.getId());
        playerSCDTO.setName(player.getName());
        playerSCDTO.setSurname(player.getSurname());
        playerSCDTO.setPatronymic(player.getPatronymic());
        playerSCDTO.setVk(player.getVk());
        playerSCDTO.setNickname(player.getNickname());
        playerSCDTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerSCDTO.setTeam(player.getTeam().getName());
            playerSCDTO.setTeamId(player.getTeam().getId());
        }
        playerSCDTO.setScAPM(player.getScAPM());
        playerSCDTO.setScLeague(player.getScLeague());
        return playerSCDTO;
    }

    private PlayerTEKKENDTO mapTEKKENToDTO(PlayerTEKKEN player) {
        PlayerTEKKENDTO playerTEKKENDTO = new PlayerTEKKENDTO();
        playerTEKKENDTO.setId(player.getId());
        playerTEKKENDTO.setName(player.getName());
        playerTEKKENDTO.setSurname(player.getSurname());
        playerTEKKENDTO.setPatronymic(player.getPatronymic());
        playerTEKKENDTO.setVk(player.getVk());
        playerTEKKENDTO.setNickname(player.getNickname());
        playerTEKKENDTO.setGame(player.getGame());
        if (player.getTeam() != null) {
            playerTEKKENDTO.setTeam(player.getTeam().getName());
            playerTEKKENDTO.setTeamId(player.getTeam().getId());
        }
        playerTEKKENDTO.setTekkenRank(player.getTekkenRank());
        return playerTEKKENDTO;
    }

    private FreePlayerDTO mapToFreePlayer(Player player) {
        FreePlayerDTO playerDTO = new FreePlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setNickname(player.getNickname());
        return playerDTO;
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
