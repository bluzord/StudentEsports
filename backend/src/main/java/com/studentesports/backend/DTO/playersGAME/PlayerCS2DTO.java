package com.studentesports.backend.DTO.playersGAME;

import lombok.Data;

@Data
public class PlayerCS2DTO {
    Integer id;
    String name;
    String surname;
    String patronymic;
    String vk;
    String nickname;
    String game;
    String team;
    Integer teamId;
    String steamURL;
    Integer faceitELO;
    String faceitURL;
}
