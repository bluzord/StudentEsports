package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.*;
import com.studentesports.backend.DTO.playersGAME.*;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.Team;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.models.players.*;
import com.studentesports.backend.services.ApplicationService;
import com.studentesports.backend.services.NewsService;
import com.studentesports.backend.services.PlayerService;
import com.studentesports.backend.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/")
public class AdminController {

    private final ApplicationService applicationService;
    private final NewsService newsService;
    private final PlayerService playerService;
    private final TeamService teamService;

    public AdminController(ApplicationService applicationService, NewsService newsService, PlayerService playerService, TeamService teamService) {
        this.applicationService = applicationService;
        this.newsService = newsService;
        this.playerService = playerService;
        this.teamService = teamService;
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

    @PostMapping("teams/create")
    public ResponseEntity<Team> createTeam(@RequestParam("logo")MultipartFile logo,
                                           @RequestParam("name")String name,
                                           @RequestParam("game")String game) throws IOException {
        return ResponseEntity.ok(teamService.createTeam(logo, name, game));
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
    public ResponseEntity<List<PlayerCS2DTO>> getCS2Players() {
        return ResponseEntity.ok(playerService.getPlayersCS2());
    }

    @GetMapping("players/dota")
    public ResponseEntity<List<PlayerDOTADTO>> getDOTAPlayers() {
        return ResponseEntity.ok(playerService.getPlayersDOTA());
    }

    @GetMapping("players/lol")
    public ResponseEntity<List<PlayerLOLDTO>> getLOLPlayers() {
        return ResponseEntity.ok(playerService.getPlayersLOL());
    }

    @GetMapping("players/sc")
    public ResponseEntity<List<PlayerSCDTO>> getSCPlayers() {
        return ResponseEntity.ok(playerService.getPlayersSC());
    }

    @GetMapping("players/tekken")
    public ResponseEntity<List<PlayerTEKKENDTO>> getTEKKENPlayers() {
        return ResponseEntity.ok(playerService.getPlayersTEKKEN());
    }

    @GetMapping("players/vlr")
    public ResponseEntity<List<PlayerVLRDTO>> getVLRPlayers() {
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

    @GetMapping("teams/{id}")
    public ResponseEntity<TeamComposition> getTeamForEdit(@PathVariable("id") int id) {
        return ResponseEntity.ok(teamService.getTeamForEdit(id));
    }

    @GetMapping("players/{game}/free")
    public ResponseEntity<List<FreePlayerDTO>> getFreePlayers(@PathVariable("game") String game) {
        switch (game) {
            case "CS2" -> {
                return ResponseEntity.ok(playerService.getFreePlayersCS2());
            }
            case "DOTA" -> {
                return ResponseEntity.ok(playerService.getFreePlayersDOTA());
            }
            case "LOL" -> {
                return ResponseEntity.ok(playerService.getFreePlayersLOL());
            }
            case "VLR" -> {
                return ResponseEntity.ok(playerService.getFreePlayersVLR());
            }
            case "SC2" -> {
                return ResponseEntity.ok(playerService.getFreePlayersSC());
            }
            case "TEKKEN" -> {
                return ResponseEntity.ok(playerService.getFreePlayersTEKKEN());
            }
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PutMapping("teams/update-players")
    public ResponseEntity<String> updateTeamPlayers(@RequestBody TeamComposition team) {
        teamService.updateTeamPlayers(team);
        return ResponseEntity.ok("Состав обновлен");
    }
}


