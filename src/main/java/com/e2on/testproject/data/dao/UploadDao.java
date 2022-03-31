package com.e2on.testproject.data.dao;

import com.e2on.testproject.data.dto.UploadDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UploadDao extends CrudRepository<UploadDto, Long> {

    Optional<UploadDto> findById(Long a);
    Optional<UploadDto> findByFileSetNameAndFilePath(String FileSetName, String FilePath);

}
