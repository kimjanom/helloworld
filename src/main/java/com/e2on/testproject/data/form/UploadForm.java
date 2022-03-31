package com.e2on.testproject.data.form;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
@Builder
@Getter
public class UploadForm {
    private Long id;
    private String email;
    private String name;
    private String title;
    private String fileOriginalName;
    private String fileSetName;
    private String content;
    private String filePath;
    private LocalDateTime uploadDate;
}
//    public UploadDto toEntity(){
//        return new UploadDto(1l,email,name,title,uploadDate,content);
//    }
//}
