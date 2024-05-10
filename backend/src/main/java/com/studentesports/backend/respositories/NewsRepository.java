package com.studentesports.backend.respositories;

import com.studentesports.backend.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
