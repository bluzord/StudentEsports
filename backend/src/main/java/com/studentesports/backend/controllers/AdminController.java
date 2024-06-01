package com.studentesports.backend.controllers;

import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/")
public class AdminController {

    private final ApplicationService applicationService;

    public AdminController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("OK!");
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
