package com.studentesports.backend.models.applications;

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
@Table(name = "applications_dota")
public class ApplicationDOTA extends Application{
    @Column(name = "steam_url")
    private String steamURL;

    @Column(name = "dota_mmr")
    private Integer dotaMMR;

    @Column(name = "dota_pos")
    private String dotaPos;

    @Column(name = "dota_buff")
    private String dotaBuff;

    public ApplicationDOTA( String name, String surname, String patronymic, String vk, String nickname, String game, String steamURL, Integer dotaMMR, String dotaPos, String dotaBuff) {
        super(name, surname, patronymic, vk, nickname, game);
        this.steamURL = steamURL;
        this.dotaMMR = dotaMMR;
        this.dotaPos = dotaPos;
        this.dotaBuff = dotaBuff;
    }
}
