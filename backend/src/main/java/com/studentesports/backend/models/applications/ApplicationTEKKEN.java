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
@Table(name = "applications_tekken")
public class ApplicationTEKKEN extends Application{

    @Column(name = "tekken_rank")
    private String tekkenRank;

    public ApplicationTEKKEN( String name, String surname, String patronymic, String vk, String nickname, String game, String tekkenRank) {
        super(name, surname, patronymic, vk, nickname, game);
        this.tekkenRank = tekkenRank;
    }
}
