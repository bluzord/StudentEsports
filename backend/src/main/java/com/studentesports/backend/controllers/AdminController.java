package com.studentesports.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/")
public class AdminController {

    @GetMapping("check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("OK!");
    }
}
