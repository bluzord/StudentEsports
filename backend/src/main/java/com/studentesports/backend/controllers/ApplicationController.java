package com.studentesports.backend.controllers;

import com.studentesports.backend.models.Application;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        this.applicationService.createApplication(application);
        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }

}
