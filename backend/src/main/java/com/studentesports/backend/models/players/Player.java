package com.studentesports.backend.models.players;

import com.studentesports.backend.models.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="players")
@Inheritance (strategy = InheritanceType.JOINED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String nickname;
    private String vk;
    private String game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    private String avatar;

    public Player(String name, String surname, String patronymic, String nickname, String vk, String game) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.vk = vk;
        this.game = game;
        this.team = null;
        this.avatar = "SE.svg";
    }
}
