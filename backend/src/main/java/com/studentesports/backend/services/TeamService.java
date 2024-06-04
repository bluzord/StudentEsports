package com.studentesports.backend.services;

import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.DTO.TeamComposition;
import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.Team;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TeamService {
    List<TeamDTO> getTeams();
    Team createTeam(MultipartFile logo, String name, String game) throws IOException;
    TeamComposition getTeamForEdit(int id);
    void updateTeamPlayers(TeamComposition team);
}
