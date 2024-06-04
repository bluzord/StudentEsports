package com.studentesports.backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TeamComposition {
    Integer id;
    String name;
    String game;
    List<FreePlayerDTO> players;
}
