package com.studentesports.backend.respositories;

import com.studentesports.backend.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
