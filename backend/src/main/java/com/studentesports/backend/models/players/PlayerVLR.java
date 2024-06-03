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
@Table(name = "players_vlr")
public class PlayerVLR extends Player{
    @Column(name = "riot_id")
    private String riotID;

    @Column(name = "vlr_role")
    private String vlrRole;

    @Column(name = "vlr_rank")
    private String vlrRank;

    public PlayerVLR(String name, String surname, String patronymic, String nickname, String vk, String game, String riotID, String vlrRole, String vlrRank) {
        super(name, surname, patronymic, nickname, vk, game);
        this.riotID = riotID;
        this.vlrRole = vlrRole;
        this.vlrRank = vlrRank;
    }
}
