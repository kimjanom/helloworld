package com.e2on.testproject.data.config.security;

import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.form.MemberForm;
import com.e2on.testproject.data.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginIdPwValidator implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MemberDao memberDao;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberDto user = memberDao.findByEmail(email);

        if (user==null){
            return null;
        }
        String pw= user.getPassword();

        return User.builder()
                .username(email)
                .password(pw)
                .build();
    }
}
