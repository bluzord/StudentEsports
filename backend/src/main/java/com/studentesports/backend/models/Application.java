package com.studentesports.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String vk;
    private String nickname;
    private String game;

    @Column(name = "steam_url")
    private String steamURL;

    @Column(name = "faceit_elo")
    private Integer faceitELO;

    @Column(name = "faceit_url")
    private String faceitURL;

    @Column(name = "dota_mmr")
    private Integer dotaMMR;

    @Column(name = "dota_pos")
    private String dotaPos;

    @Column(name = "dota_buff")
    private String dotaBuff;

    @Column(name = "riot_id")
    private String riotID;

    @Column(name = "vlr_role")
    private String vlrRole;

    @Column(name = "vlr_rank")
    private String vlrRank;

    @Column(name = "lol_pos")
    private String lolPos;

    @Column(name = "lol_rank")
    private String lolRank;

    @Column(name = "tekken_rank")
    private String tekkenRank;

    @Column(name = "sc_league")
    private String SCLeague;

    @Column(name = "sc_apm")
    private Integer SCAPM;
}
