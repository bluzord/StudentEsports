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
@Table(name = "applications_vlr")
public class ApplicationVLR extends Application{
    @Column(name = "riot_id")
    private String riotID;

    @Column(name = "vlr_role")
    private String vlrRole;

    @Column(name = "vlr_rank")
    private String vlrRank;

    public ApplicationVLR(String name, String surname, String patronymic, String vk, String nickname, String game, String riotID, String vlrRole, String vlrRank) {
        super(name, surname, patronymic, vk, nickname, game);
        this.riotID = riotID;
        this.vlrRole = vlrRole;
        this.vlrRank = vlrRank;
    }
}
