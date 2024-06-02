package com.studentesports.backend.services.impl;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsElement;
import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.exceptions.NewsElementNotFoundException;
import com.studentesports.backend.exceptions.NewsNotFoundException;
import com.studentesports.backend.exceptions.TeamsNotFoundException;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.Player;
import com.studentesports.backend.models.Team;
import com.studentesports.backend.respositories.NewsRepository;
import com.studentesports.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        if (listOfNews.isEmpty()) throw new NewsNotFoundException("Новости не найдены");


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
    public List<NewsCardDTO> getAdminNews() {
        List<News> news = newsRepository.findAll();
        if (news.isEmpty()) throw new NewsNotFoundException("Новости не найдены");
        return news.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public NewsElement getNewsElement(int id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new NewsElementNotFoundException("Новость не найдена"));
        NewsElement newsElement = new NewsElement();
        newsElement.setId(news.getId());
        newsElement.setTitle(news.getTitle());
        newsElement.setContent(news.getContent());
        newsElement.setImage(news.getImage());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dateStr = formatter.format(news.getDate());
        newsElement.setDate(dateStr);

        return newsElement;
    }

    @Override
    public News createNews(MultipartFile image, String title, String content) throws IOException {
        String filePath = "C:/Users/bluzord/Documents/StudentEsports/frontend/src/app/images/news/" + image.getOriginalFilename();
        News news = new News(new Date(), title, content, image.getOriginalFilename());
        System.out.println(filePath);
        image.transferTo(new File(filePath));
        newsRepository.save(news);
        return news;
    }

    @Override
    public void deleteNewsById(int id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new NewsElementNotFoundException("Новость не найдена"));
        System.out.println(news);
        newsRepository.delete(news);
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
