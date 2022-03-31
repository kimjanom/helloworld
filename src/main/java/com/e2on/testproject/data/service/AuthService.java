package com.e2on.testproject.data.service;

import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.form.LoginForm;
import com.e2on.testproject.data.form.MemberForm;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class AuthService {

//    private final MemberDto memberDto;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    private  AuthenticationManager authenticationManager= new AuthenticationManager() {
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            return null;
        }
    };

    public String register(MemberForm memberForm) {

       MemberDto existMember= memberDao.findByEmail(memberForm.getEmail());
        if(existMember!=null){
            System.out.println("existMember:"+existMember);
            System.out.println("널값?");
            return null;
        }
        MemberDto memberDto = new MemberDto();
        System.out.println("패스워드 인코딩 값:"+passwordEncoder.encode(memberForm.getPassword()));
        memberDto.setPassword(passwordEncoder.encode(memberForm.getPassword()));
        memberDto.setName(memberForm.getName());
        memberDto.setEmail(memberForm.getEmail());

        memberDao.save(memberDto);
        return memberDto.getEmail();
    }

    public String login(LoginForm loginForm) throws Exception{
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("뭐가 나올까 ?"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();


    }
}