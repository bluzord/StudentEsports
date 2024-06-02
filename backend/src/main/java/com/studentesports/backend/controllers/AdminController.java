package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsCreateDTO;
import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.services.ApplicationService;
import com.studentesports.backend.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/")
public class AdminController {

    private final ApplicationService applicationService;
    private final NewsService newsService;

    public AdminController(ApplicationService applicationService, NewsService newsService) {
        this.applicationService = applicationService;
        this.newsService = newsService;
    }

    @GetMapping("check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("OK!");
    }

    @GetMapping("news")
    public ResponseEntity<List<NewsCardDTO>> getNews() {
        List<NewsCardDTO> news = newsService.getAdminNews();
        return ResponseEntity.ok(news);
    }

    @DeleteMapping("news/{id}/delete")
    public  ResponseEntity<String> deleteNewsElement(@PathVariable("id") int newsId) {
        newsService.deleteNewsById(newsId);
        return ResponseEntity.ok("Новость удалена");
    }

    @PostMapping("news/create")
    public ResponseEntity<News> createNewsElement(@RequestParam("image")MultipartFile image,
                                                  @RequestParam("title")String title,
                                                  @RequestParam("content")String content) throws IOException {

        return ResponseEntity.ok(newsService.createNews(image, title, content));
    }

    @GetMapping("applications/cs2")
    public ResponseEntity<List<ApplicationCS2>> getCS2Applications() {
        return ResponseEntity.ok(applicationService.getApplicationsCS2());
    }

    @GetMapping("applications/dota")
    public ResponseEntity<List<ApplicationDOTA>> getDOTAApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsDOTA());
    }

    @GetMapping("applications/lol")
    public ResponseEntity<List<ApplicationLOL>> getLOLApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsLOL());
    }

    @GetMapping("applications/sc")
    public ResponseEntity<List<ApplicationSC>> getSCApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsSC());
    }

    @GetMapping("applications/tekken")
    public ResponseEntity<List<ApplicationTEKKEN>> getTEKKENApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsTEKKEN());
    }

    @GetMapping("applications/vlr")
    public ResponseEntity<List<ApplicationVLR>> getVLRApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsVLR());
    }
}
