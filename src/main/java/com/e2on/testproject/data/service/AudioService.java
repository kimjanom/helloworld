package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dao.UploadDao;
import com.e2on.testproject.data.dto.UploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
public class AudioService {
    @Autowired
    private UploadDao dao;
    @Transactional
    public ResponseEntity<byte[]> audioPlayer(Long id) throws IOException {
        Optional<UploadDto> data=dao.findById(id);
        UploadDto dto=data.get();

        FileInputStream fis=null;
        ResponseEntity<byte[]> responseEntity = null;

        HttpHeaders responseHeaders = new HttpHeaders();
        File file =new File(dto.getFilePath());
        responseHeaders.add("Content-Type","audio/mpeg");

        try {
            fis=new FileInputStream(file);
            int initFileSize=(int)file.length();
            byte[] buf =new byte[initFileSize];
            int readBuf;
            readBuf = fis.read(buf,0,initFileSize);
            responseEntity=new ResponseEntity<>(buf,responseHeaders,HttpStatus.CREATED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new byte[0], responseHeaders, HttpStatus.NOT_FOUND);
        }finally {
            if (fis != null) {
                fis.close();
            }
        }
        return responseEntity;


    }

}
