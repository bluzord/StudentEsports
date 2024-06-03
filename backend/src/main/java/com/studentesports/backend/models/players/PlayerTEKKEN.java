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
@Table(name = "players_tekken")
public class PlayerTEKKEN extends Player{
    @Column(name = "tekken_rank")
    private String tekkenRank;

    public PlayerTEKKEN(String name, String surname, String patronymic, String nickname, String vk, String game, String tekkenRank) {
        super(name, surname, patronymic, nickname, vk, game);
        this.tekkenRank = tekkenRank;
    }
}
