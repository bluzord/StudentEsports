package com.studentesports.backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class NewsCardResponse {
    private List<NewsCardDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalNews;
    private Integer totalPages;
}
