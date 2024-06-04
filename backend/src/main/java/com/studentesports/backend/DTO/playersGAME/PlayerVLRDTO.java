package com.studentesports.backend.DTO.playersGAME;

import lombok.Data;

@Data
public class PlayerVLRDTO {
    Integer id;
    String name;
    String surname;
    String patronymic;
    String vk;
    String nickname;
    String game;
    String team;
    Integer teamId;
    String riotID;
    String vlrRole;
    String vlrRank;
}
