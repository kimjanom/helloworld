package com.e2on.testproject.data.dao;

import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.form.MemberForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao extends CrudRepository<MemberDto, Long> {
    @Query("SELECT dto FROM MemberDto dto WHERE dto.email = :email")
    MemberForm findByEmail(@Param("email") String email) ;

    @Query("SELECT dto FROM MemberDto dto WHERE dto.password = :password")
    MemberDto findByPassword(@Param("password") String password) ;

    MemberDto findByEmailAndPassword(String email, String password);
}
