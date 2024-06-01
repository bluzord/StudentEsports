package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsElement;
import com.studentesports.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("news")
    public ResponseEntity<NewsCardResponse> getNews(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(newsService.getNews(pageNumber, pageSize));
    }

    @GetMapping("news/{id}")
    public ResponseEntity<NewsElement> getNewsElement(@PathVariable Integer id) {
        return ResponseEntity.ok(newsService.getNewsElement(id));
    }
}
