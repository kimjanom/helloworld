package com.e2on.testproject.data.controller;

import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @Autowired
    MemberDao memberdao;
    @Autowired
    MemberService memberService;

    //    Session session=null;
//    Transaction transaction=null;
//
//    public String login() {
//        session = HibernateUtil.getSessionFactory().openSession();
//    }
    @RequestMapping(value = "/register1")
    public String register(@RequestParam String email, String name, String password) {
        System.out.println("1---------------");
        System.out.println(email);
        System.out.println(name);
        System.out.println(password);
        System.out.println("2------------------");
        MemberDto member = new MemberDto();
        member.setEmail(email);
        member.setName(name);
        member.setPassword(password);
        System.out.print(member.toString());
        memberService.register(member);
        System.out.print("3--------------------");
//    MemberDto save=memberdao.save(member);
        System.out.print("MemberController");
        return "redirect:/";
    }


}
