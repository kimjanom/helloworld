package com.e2on.testproject.data.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    LoginIdPwValidator loginIdPwValidator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                ---.anyRequest().authenticated() 는 어떠란 URL로 접근하던지 인증이 필요함을 설정한다
                .anyRequest().authenticated()
                .and()
//                ---'formLogin()'에서 폼방식 로그인을 사용할 것임을 알리고, logout도 필요하니 logout도 추가
                .formLogin()
                .loginPage("/nidlogin")
                .loginProcessingUrl("/auth/login")
                .usernameParameter("id")
                .passwordParameter("pw")
//                ---'defaultSuccessUrl'로 로그인 성공 시 이동할 uri를 적어준다
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/board/","/auth/register1","/register","/auth/login");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator);

    }
}
