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
@Table(name = "players_sc")
public class PlayerSC extends Player{
    @Column(name = "sc_league")
    private String scLeague;

    @Column(name = "sc_apm")
    private Integer scAPM;

    public PlayerSC(String name, String surname, String patronymic, String nickname, String vk, String game, String scLeague, Integer scAPM) {
        super(name, surname, patronymic, nickname, vk, game);
        this.scLeague = scLeague;
        this.scAPM = scAPM;
    }
}
