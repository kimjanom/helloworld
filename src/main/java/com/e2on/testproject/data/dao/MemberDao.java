package com.e2on.testproject.data.dao;

import com.e2on.testproject.data.dto.MemberDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberDao extends CrudRepository<MemberDto, Long> {

    @Query("SELECT dto FROM MemberDto dto WHERE dto.email = :email")
    MemberDto findByEmail(@Param("email") String email) ;

    @Query("SELECT dto FROM MemberDto dto WHERE dto.password = :password")
    MemberDto findByPassword(@Param("password") String password) ;

    @Query("SELECT dto FROM MemberDto dto WHERE dto.email = :email")
    List<MemberDto> findByEmails(@Param("email") String email) ;
//    String findByEmail(@Param("email") String email);

    Optional<MemberDto> findById(Long id);

}
