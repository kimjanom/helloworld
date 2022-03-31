package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dao.UploadDao;
import com.e2on.testproject.data.dto.UploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Optional;

@Service
public class DeleteService {
    @Autowired
    UploadDao uploadDao;
    @Transactional
    public void delete(Long id){
        Optional<UploadDto> updao = uploadDao.findById(id);
        UploadDto uploadDto = updao.get();
        File file =new File(uploadDto.getFilePath()+"/"+uploadDto.getFileSetName());
        if(file.exists()){
            if(file.delete()){
                uploadDao.deleteById(id);
                System.out.println("삭제된 파일이름:"+uploadDto.getFileSetName());
                System.out.println("삭제 성공");
            }
            else{
                System.out.println("실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다");
        }
    }
}
