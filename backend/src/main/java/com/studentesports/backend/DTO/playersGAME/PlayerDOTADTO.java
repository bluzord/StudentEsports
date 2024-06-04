package com.studentesports.backend.DTO.playersGAME;

import lombok.Data;

@Data
public class PlayerDOTADTO {
    Integer id;
    String name;
    String surname;
    String patronymic;
    String vk;
    String nickname;
    String game;
    String team;
    Integer teamId;
    String SteamURL;
    Integer dotaMMR;
    String dotaPos;
    String dotaBuff;
}
