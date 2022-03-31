package com.e2on.testproject;

import com.e2on.testproject.data.controller.MemberController;
import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.service.CheckService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableJpaAuditing
@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
        System.out.printf("helloworld");


//        Session session=SessionFactory.openSession();
//        session.beginTransaction();

    }


}
