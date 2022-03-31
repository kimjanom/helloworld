package com.e2on.testproject.data.service;

import com.e2on.testproject.data.form.MemberForm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

    public MemberForm loadUserByUsername(String email) throws UsernameNotFoundException;
}
