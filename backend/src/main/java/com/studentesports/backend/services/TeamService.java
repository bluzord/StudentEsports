package com.studentesports.backend.services;

import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.DTO.TeamDTO;

import java.util.List;

public interface TeamService {
    List<TeamDTO> getTeams();
}
