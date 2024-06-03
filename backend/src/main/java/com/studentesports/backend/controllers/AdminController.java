package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.NewsCardDTO;
import com.studentesports.backend.DTO.NewsCardResponse;
import com.studentesports.backend.DTO.NewsCreateDTO;
import com.studentesports.backend.DTO.TeamDTO;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.models.players.*;
import com.studentesports.backend.services.ApplicationService;
import com.studentesports.backend.services.NewsService;
import com.studentesports.backend.services.PlayerService;
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
    private final PlayerService playerService;

    public AdminController(ApplicationService applicationService, NewsService newsService, PlayerService playerService) {
        this.applicationService = applicationService;
        this.newsService = newsService;
        this.playerService = playerService;
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

    @DeleteMapping("applications/{id}/delete")
    public  ResponseEntity<String> deleteApplication(@PathVariable("id") int id) {
        applicationService.deleteApplicationById(id);
        return ResponseEntity.ok("Заявка удалена");
    }

    @GetMapping("applications/vlr")
    public ResponseEntity<List<ApplicationVLR>> getVLRApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsVLR());
    }

    @GetMapping("players/cs2")
    public ResponseEntity<List<PlayerCS2>> getCS2Players() {
        return ResponseEntity.ok(playerService.getPlayersCS2());
    }

    @GetMapping("players/dota")
    public ResponseEntity<List<PlayerDOTA>> getDOTAPlayers() {
        return ResponseEntity.ok(playerService.getPlayersDOTA());
    }

    @GetMapping("players/lol")
    public ResponseEntity<List<PlayerLOL>> getLOLPlayers() {
        return ResponseEntity.ok(playerService.getPlayersLOL());
    }

    @GetMapping("players/sc")
    public ResponseEntity<List<PlayerSC>> getSCPlayers() {
        return ResponseEntity.ok(playerService.getPlayersSC());
    }

    @GetMapping("players/tekken")
    public ResponseEntity<List<PlayerTEKKEN>> getTEKKENPlayers() {
        return ResponseEntity.ok(playerService.getPlayersTEKKEN());
    }

    @GetMapping("players/vlr")
    public ResponseEntity<List<PlayerVLR>> getVLRPlayers() {
        return ResponseEntity.ok(playerService.getPlayersVLR());
    }

    @PostMapping("players/cs2/create")
    public ResponseEntity<String> createCS2Player(@RequestBody ApplicationCS2 application) {
        playerService.createPlayerCS2(application);
        return ResponseEntity.ok("Игрок создан");
    }

    @PostMapping("players/dota/create")
    public ResponseEntity<String> createDOTAPlayer(@RequestBody ApplicationDOTA application) {
        playerService.createPlayerDOTA(application);
        return ResponseEntity.ok("Игрок создан");
    }

    @PostMapping("players/lol/create")
    public ResponseEntity<String> createLOLPlayer(@RequestBody ApplicationLOL application) {
        playerService.createPlayerLOL(application);
        return ResponseEntity.ok("Игрок создан");
    }

    @PostMapping("players/vlr/create")
    public ResponseEntity<String> createVLRPlayer(@RequestBody ApplicationVLR application) {
        playerService.createPlayerVLR(application);
        return ResponseEntity.ok("Игрок создан");
    }

    @PostMapping("players/sc/create")
    public ResponseEntity<String> createSCPlayer(@RequestBody ApplicationSC application) {
        playerService.createPlayerSC(application);
        return ResponseEntity.ok("Игрок создан");
    }

    @PostMapping("players/tekken/create")
    public ResponseEntity<String> createTEKKENPlayer(@RequestBody ApplicationTEKKEN application) {
        playerService.createPlayerTEKKEN(application);
        return ResponseEntity.ok("Игрок создан");
    }
}


