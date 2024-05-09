package com.studentesports.backend.services;

import com.studentesports.backend.DTO.PlayerDTO;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getPlayers();
}
