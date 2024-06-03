package com.studentesports.backend.models.players;

import com.studentesports.backend.models.Team;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players_cs2")
public class PlayerCS2 extends Player{
    @Column(name = "steam_url")
    private String steamURL;

    @Column(name = "faceit_elo")
    private Integer faceitELO;

    @Column(name = "faceit_url")
    private String faceitURL;

    public PlayerCS2(String name, String surname, String patronymic, String nickname, String vk, String game, String steamURL, Integer faceitELO, String faceitURL) {
        super(name, surname, patronymic, nickname, vk, game);
        this.steamURL = steamURL;
        this.faceitELO = faceitELO;
        this.faceitURL = faceitURL;
    }
}
