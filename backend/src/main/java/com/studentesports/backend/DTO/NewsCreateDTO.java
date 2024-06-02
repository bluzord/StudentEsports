package com.studentesports.backend.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NewsCreateDTO {
    MultipartFile image;
    String title;
    String content;
}
