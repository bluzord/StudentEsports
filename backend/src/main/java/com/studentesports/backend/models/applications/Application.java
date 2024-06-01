package com.studentesports.backend.models.applications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "applications")
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String vk;
    private String nickname;
    private String game;

    public Application(String name, String surname, String patronymic, String vk, String nickname, String game) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.vk = vk;
        this.nickname = nickname;
        this.game = game;
    }
}
