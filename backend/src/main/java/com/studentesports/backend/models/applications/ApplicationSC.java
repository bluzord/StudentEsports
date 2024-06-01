package com.studentesports.backend.models.applications;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications_sc")
public class ApplicationSC extends Application{
    @Column(name = "sc_league")
    private String SCLeague;

    @Column(name = "sc_apm")
    private Integer SCAPM;

    public ApplicationSC( String name, String surname, String patronymic, String vk, String nickname, String game, String SCLeague, Integer SCAPM) {
        super(name, surname, patronymic, vk, nickname, game);
        this.SCLeague = SCLeague;
        this.SCAPM = SCAPM;
    }
}
