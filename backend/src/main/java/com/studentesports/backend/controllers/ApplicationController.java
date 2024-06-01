package com.studentesports.backend.controllers;

import com.studentesports.backend.DTO.ApplicationDTO;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("application/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createApplication(@RequestBody ApplicationDTO application) {
        System.out.println(application);
        switch (application.getGame()) {
            case "CS2" -> {
                ApplicationCS2 newCS2Application = new ApplicationCS2(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getSteamURL(),
                        application.getFaceitELO(),
                        application.getFaceitURL()
                        );
                this.applicationService.createApplicationCS2(newCS2Application);
            }
            case "DOTA" -> {
                ApplicationDOTA newDOTAApplication = new ApplicationDOTA(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getSteamURL(),
                        application.getDotaMMR(),
                        application.getDotaPos(),
                        application.getDotaBuff()
                );
                this.applicationService.createApplicationDOTA(newDOTAApplication);
            }
            case "LOL" -> {
                ApplicationLOL newLOLApplication = new ApplicationLOL(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getRiotID(),
                        application.getLolPos(),
                        application.getLolRank()
                );
                this.applicationService.createApplicationLOL(newLOLApplication);
            }
            case "VLR" -> {
                ApplicationVLR newVLRApplication = new ApplicationVLR(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getRiotID(),
                        application.getVlrRole(),
                        application.getVlrRank()
                );
                this.applicationService.createApplicationVLR(newVLRApplication);
            }
            case "SC" -> {
                ApplicationSC newSCApplication = new ApplicationSC(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getSCLeague(),
                        application.getSCAPM()
                );
                this.applicationService.createApplicationSC(newSCApplication);
            }
            case "TEKKEN" -> {
                ApplicationTEKKEN newTEKKENApplication = new ApplicationTEKKEN(
                        application.getName(),
                        application.getSurname(),
                        application.getPatronymic(),
                        application.getVk(),
                        application.getNickname(),
                        application.getGame(),
                        application.getTekkenRank()
                );
                this.applicationService.createApplicationTEKKEN(newTEKKENApplication);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
