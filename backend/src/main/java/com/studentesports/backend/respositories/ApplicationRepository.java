package com.studentesports.backend.respositories;

import com.studentesports.backend.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
