package com.studentesports.backend.DTO;

import lombok.Data;

@Data
public class PlayerDTO {
    private Integer id;
    private String name;
    private String surname;
    private String nickname;
    private String game;
    private String team;
    private String avatar;
}
