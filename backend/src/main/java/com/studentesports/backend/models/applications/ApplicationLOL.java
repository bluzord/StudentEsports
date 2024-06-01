package com.studentesports.backend.models.applications;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications_lol")
public class ApplicationLOL extends Application{
    @Column(name = "riot_id")
    private String riotID;

    @Column(name = "lol_pos")
    private String lolPos;

    @Column(name = "lol_rank")
    private String lolRank;

    public ApplicationLOL( String name, String surname, String patronymic, String vk, String nickname, String game, String riotID, String lolPos, String lolRank) {
        super(name, surname, patronymic, vk, nickname, game);
        this.riotID = riotID;
        this.lolPos = lolPos;
        this.lolRank = lolRank;
    }
}
