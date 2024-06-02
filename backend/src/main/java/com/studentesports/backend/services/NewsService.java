package com.studentesports.backend.services;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsElement;
import com.studentesports.backend.models.News;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    NewsCardResponse getNews(int pageNumber, int pageSize);
    List<NewsCardDTO> getAdminNews();

    NewsElement getNewsElement(int id);
    News createNews(MultipartFile image, String title, String content) throws IOException;

    void deleteNewsById(int id);
}
