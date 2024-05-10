package com.studentesports.backend.services;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsElement;

import java.util.List;

public interface NewsService {
    NewsCardResponse getNews(int pageNumber, int pageSize);

    NewsElement getNewsElement(int id);
}
