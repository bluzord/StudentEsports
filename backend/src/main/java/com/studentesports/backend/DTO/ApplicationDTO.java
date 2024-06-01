package com.studentesports.backend.DTO;

import lombok.Data;

@Data
public class ApplicationDTO {
    private String name;
    private String surname;
    private String patronymic;
    private String vk;
    private String nickname;
    private String game;
    private String steamURL;
    private Integer faceitELO;
    private String faceitURL;
    private Integer dotaMMR;
    private String dotaPos;
    private String dotaBuff;
    private String riotID;
    private String vlrRole;
    private String vlrRank;
    private String lolPos;
    private String lolRank;
    private String tekkenRank;
    private String SCLeague;
    private Integer SCAPM;
}
