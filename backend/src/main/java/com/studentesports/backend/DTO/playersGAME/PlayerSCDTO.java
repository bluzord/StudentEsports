package com.studentesports.backend.DTO.playersGAME;

import lombok.Data;

@Data
public class PlayerSCDTO {
    Integer id;
    String name;
    String surname;
    String patronymic;
    String vk;
    String nickname;
    String game;
    String team;
    Integer teamId;
    String scLeague;
    Integer scAPM;
}
