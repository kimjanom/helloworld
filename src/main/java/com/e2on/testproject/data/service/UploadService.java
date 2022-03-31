package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dto.UploadDto;
import com.e2on.testproject.data.form.UploadForm;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;


public interface UploadService {
    public void insertDataTest(UploadDto dto, MultipartHttpServletRequest multipartHttpServletRequest);
    public void insertData(UploadDto dto, MultipartHttpServletRequest multipartHttpServletRequest);
    public List<UploadForm> getUploadlist();
//    public UploadDto findById(Long id);


}
