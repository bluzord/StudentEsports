package com.studentesports.backend.respositories;

import com.studentesports.backend.models.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
