package com.e2on.testproject.data.controller;

import com.e2on.testproject.data.form.LoginForm;
import com.e2on.testproject.data.form.MemberForm;
import com.e2on.testproject.data.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/register1")
    public String register(MemberForm memberForm){
        System.out.println("도착");
        System.out.println("파라미터 체크:"+memberForm);
        return authService.register(memberForm);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginForm loginForm){
        System.out.println("로그인 컨트롤러");
        System.out.println("폼값"+loginForm);
        try{
            return authService.login(loginForm);
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
