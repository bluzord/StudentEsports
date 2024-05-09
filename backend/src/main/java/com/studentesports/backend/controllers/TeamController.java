package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("teams")
    public ResponseEntity<List<TeamDTO>> getTeams() {
        List<TeamDTO> teams = teamService.getTeams();
        return ResponseEntity.ok(teams);
    }
}
