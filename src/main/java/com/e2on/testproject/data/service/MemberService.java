package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MemberService {

    @Autowired
    MemberDao memberdao;

    public boolean register(MemberDto a){
        System.out.println("Memberservice");
        String pwd = a.getPassword();

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pwd.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        a.setPassword(myHash);
        MemberDto findMember=memberdao.findByEmail(a.getEmail());
        System.out.println("---------------1"+a);
        System.out.println("-----------------2"+memberdao.findByEmail(a.getEmail()));

        if(findMember==null){
            System.out.println("null");
            memberdao.save(a);
            System.out.println("회원가입 성공");
            return false;
        }
        System.out.println("회원가입 실패");
        return true;

    }

}
