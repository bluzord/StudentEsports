package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsElement;
import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.Player;
import com.studentesports.backend.respositories.NewsRepository;
import com.studentesports.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsCardResponse getNews(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("date").descending());
        Page<News> news = newsRepository.findAll(pageable);
        List<News> listOfNews = news.getContent();

        List<NewsCardDTO> content = listOfNews.stream().map(this::mapToDTO).collect(Collectors.toList());
        NewsCardResponse newsCardResponse = new NewsCardResponse();
        newsCardResponse.setContent(content);
        newsCardResponse.setPageNumber(news.getNumber());
        newsCardResponse.setPageSize(news.getSize());
        newsCardResponse.setTotalNews(news.getTotalElements());
        newsCardResponse.setTotalPages(news.getTotalPages());

        return newsCardResponse;
    }

    @Override
    public NewsElement getNewsElement(int id) {
        News news = newsRepository.findById(id).orElseThrow();
        NewsElement newsElement = new NewsElement();
        newsElement.setId(news.getId());
        newsElement.setTitle(news.getTitle());
        newsElement.setContent(List.of(news.getContent().split("\n\n")));
        newsElement.setImage(news.getImage());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dateStr = formatter.format(news.getDate());
        newsElement.setDate(dateStr);

        return newsElement;
    }


    private NewsCardDTO mapToDTO(News news) {
        NewsCardDTO newsCardDTO = new NewsCardDTO();
        newsCardDTO.setId(news.getId());
        newsCardDTO.setTitle(news.getTitle());
        newsCardDTO.setImage(news.getImage());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dateStr = formatter.format(news.getDate());
        newsCardDTO.setDate(dateStr);

        return newsCardDTO;
    }
}
