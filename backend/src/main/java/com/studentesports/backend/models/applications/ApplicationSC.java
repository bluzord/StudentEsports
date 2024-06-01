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
@Table(name = "applications_sc")
public class ApplicationSC extends Application{
    @Column(name = "sc_league")
    private String scLeague;

    @Column(name = "sc_apm")
    private Integer scAPM;

    public ApplicationSC( String name, String surname, String patronymic, String vk, String nickname, String game, String scLeague, Integer scAPM) {
        super(name, surname, patronymic, vk, nickname, game);
        this.scLeague = scLeague;
        this.scAPM = scAPM;
    }
}
