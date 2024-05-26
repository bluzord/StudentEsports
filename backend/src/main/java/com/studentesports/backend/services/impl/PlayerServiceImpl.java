package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.exceptions.PlayersNotFoundException;
import com.studentesports.backend.models.Player;
import com.studentesports.backend.respositories.PlayerRepository;
import com.studentesports.backend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerDTO> getPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) throw new PlayersNotFoundException("Игроки не найдены");
        return players.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private PlayerDTO mapToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setSurname(player.getSurname());
        playerDTO.setNickname(player.getNickname());
        playerDTO.setGame(player.getGame());
        playerDTO.setTeam(player.getTeam().getName());
        playerDTO.setAvatar(player.getAvatar());
        return playerDTO;
    }
}
