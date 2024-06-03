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
@Table(name = "players_lol")
public class PlayerLOL extends Player{
    @Column(name = "riot_id")
    private String riotID;

    @Column(name = "lol_pos")
    private String lolPos;

    @Column(name = "lol_rank")
    private String lolRank;

    public PlayerLOL(String name, String surname, String patronymic, String nickname, String vk, String game, String riotID, String lolPos, String lolRank) {
        super(name, surname, patronymic, nickname, vk, game);
        this.riotID = riotID;
        this.lolPos = lolPos;
        this.lolRank = lolRank;
    }
}
