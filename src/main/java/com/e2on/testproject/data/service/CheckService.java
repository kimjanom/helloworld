package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dao.UploadDao;
import com.e2on.testproject.data.dto.UploadDto;
import com.e2on.testproject.data.form.UploadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckService {
    @Value("C:/testupload/")
    String rootPath;
    @Autowired
    UploadDao uploadDao;

    @Transactional
    public void dataChecker() {
        List<UploadDto> list = (List<UploadDto>) uploadDao.findAll();
        List<UploadForm> uploadDtoList = new ArrayList<>();
        for (UploadDto dto : list) {
            UploadForm uploadForm = UploadForm.builder()
                    .id(dto.getId())
                    .filePath(dto.getFilePath())
                    .fileSetName(dto.getFileSetName())
                    .build();
            File file = new File(uploadForm.getFilePath() + "/" + uploadForm.getFileSetName());
            if (!file.exists()) {
                uploadDao.deleteById(uploadForm.getId());
            }
//            File rootFile = new File(uploadForm.getFilePath());
//            clearFile(rootFile, uploadForm.getFileSetName());
        }


    }

//    public boolean clearFile(File rootFile, String fileName) {
//        File[] allFiles = rootFile.listFiles();
//
//        if (allFiles != null) {
//            System.out.println("---------------allFiles ---------------" +allFiles);
//
//            for (File files : allFiles) {
//                System.out.println("---------------Files ---------------" +files);
//                if (uploadDao.findByFileSetNameAndFilePath(rootFile.getPath(), fileName) == null) {
//                    System.out.println("---------------널체크 ---------------" + uploadDao.findByFileSetNameAndFilePath(rootFile.getPath(), fileName));
//                    clearFile(files, fileName);
//                }
//            }
//        }
//        System.out.println("remove file:" + rootFile.getPath());
//        return rootFile.delete();
//    }
}
