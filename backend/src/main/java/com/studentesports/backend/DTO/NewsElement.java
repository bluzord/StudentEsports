package com.studentesports.backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class NewsElement {
    private Integer id;
    private String title;
    private List<String> content;
    private String image;
    private String date;
}