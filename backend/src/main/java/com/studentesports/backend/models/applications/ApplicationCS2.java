package com.studentesports.backend.models.applications;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications_cs2")
public class ApplicationCS2 extends Application{
    @Column(name = "steam_url")
    private String steamURL;

    @Column(name = "faceit_elo")
    private Integer faceitELO;

    @Column(name = "faceit_url")
    private String faceitURL;

    public ApplicationCS2( String name, String surname, String patronymic, String vk, String nickname, String game, String steamURL, Integer faceitELO, String faceitURL) {
        super(name, surname, patronymic, vk, nickname, game);
        this.steamURL = steamURL;
        this.faceitELO = faceitELO;
        this.faceitURL = faceitURL;
    }
}
