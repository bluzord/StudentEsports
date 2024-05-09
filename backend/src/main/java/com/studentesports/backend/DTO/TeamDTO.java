package com.studentesports.backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private String game;
    private Integer captainIndex;
    private List<String> players;
    private String logo;
}
