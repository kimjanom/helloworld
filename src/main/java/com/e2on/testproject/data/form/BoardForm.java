package com.e2on.testproject.data.form;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BoardForm {
    private String email;
    private String name;
    private String title;
    private String filePath;
    private String fileOriginalName;
    private LocalDateTime uploadDate;
    private String content;
}
