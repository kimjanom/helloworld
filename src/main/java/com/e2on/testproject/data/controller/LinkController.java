package com.e2on.testproject.data.controller;

import com.e2on.testproject.data.dao.LoginDao;
import com.e2on.testproject.data.dao.MemberDao;
import com.e2on.testproject.data.dao.UploadDao;
import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.dto.UploadDto;
import com.e2on.testproject.data.form.MemberForm;
import com.e2on.testproject.data.form.UploadForm;
import com.e2on.testproject.data.manager.SessionManager;
import com.e2on.testproject.data.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LinkController {
    @Autowired
    CheckService checkService;
    @Autowired
    UpdateService updateService;
    @Autowired
    DeleteService deleteService;
    @Autowired
    SessionManager sessionManager;
//    @Autowired
//    LoginServiceImpl loginServiceImpl;
    @Autowired
    private UploadDao dao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private UploadServiceImpl uploadService;
    private Model model = new Model() {
        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            return null;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return false;
        }

        @Override
        public Object getAttribute(String attributeName) {
            return null;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    };

    @RequestMapping(value = "/register")
    public ModelAndView RegisterView() {
        System.out.print("MemberController");


//        return new InternalResourceView("login.tml");
        return new ModelAndView("register");


    }

    @RequestMapping(value = "/")
    public ModelAndView IndexView(HttpServletRequest request) {
        System.out.println("IndexView");
        Object memberForm = sessionManager.getSession(request);
        System.out.println("sessio--" + memberForm);
        if (memberForm == null) {
            System.out.println("sessio--" + memberForm);
            return new ModelAndView("redirect:nidlogin");
        }

        MemberDto name = memberDao.findByEmail((String) memberForm);
        System.out.println("name--" + name.getName());
        ModelAndView view = new ModelAndView();
        view.addObject("name", name.getName());
        view.setViewName("index");
        request.setAttribute("name",memberForm);
        return new ModelAndView("index");
    }

    @RequestMapping(value = "boardUpload")
    public ModelAndView BoardUploadView(HttpServletRequest request) {
        System.out.println("IndexView");
        Object memberForm = sessionManager.getSession(request);
        System.out.println("sessio--" + memberForm);
        if (memberForm == null) {
            return new ModelAndView("/nidlogin/");
        }
        System.out.println("BoardUploadView");
        return new ModelAndView("boardUpload");
    }

    @GetMapping(value = "/mp3Player/+{id}")
    public ModelAndView mp3PlayerView(@PathVariable Long id, HttpServletRequest request) {
        request.setAttribute("id", id);
        System.out.println("mp3PlayerView");
        System.out.println("id--------------" + id);
        Object memberForm = sessionManager.getSession(request);
        Optional<UploadDto> loginOpt = dao.findById(id);
        UploadDto uploadDto = loginOpt.get();
        System.out.println("--------------1");
        ModelAndView view = new ModelAndView();
        view.setViewName("mp3Player");
        view.addObject("name", uploadDto.getName());
        view.addObject("id", uploadDto.getId());
        view.addObject("title", uploadDto.getTitle());
        view.addObject("date", uploadDto.getUploadDate());
        view.addObject("content", uploadDto.getContent());
        view.addObject("email", uploadDto.getEmail());
        view.addObject("session",memberForm);
        return view;
    }

    @RequestMapping(value = "board")
    public String BoardView(Model model) {
        checkService.dataChecker();
        System.out.println("BoardView");
        List upLoadList = uploadService.getUploadlist();
        ModelAndView view = new ModelAndView();
//        view.setViewName("board");
//        view.addObject("upLoadList",upLoadList);
        model.addAttribute("upLoadList", upLoadList);
        System.out.println("게시판 정보:" + upLoadList.getClass());
//        UploadForm a=upLoadList.get(1).getClass();
//        model.addAttribute("upLoadList",)


        return "board";
    }

    @GetMapping("/nidlogin")
    public ModelAndView loginView(MemberForm memberForm,
                                  HttpServletResponse response) {
        System.out.println("loginview");
        System.out.println("---------memberForm:" + memberForm);
        System.out.println("---------response:" + response);
        return new ModelAndView("login");
    }

//    @PostMapping("/login")
//    public String login(MemberForm memberForm,
//                        HttpServletResponse response,
//                        HttpServletRequest request) {
//
//        boolean check = loginServiceImpl.login(memberForm, response);
//        System.out.println("---------check:" + check);
//        if (check == false) {
//            request.setAttribute("fail","fail");
//            System.out.println("---------실패:");
//            return "/login";
//        } else {
//            System.out.println("---------성공:");
//            return "redirect:/";
//        }
//    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    @PostMapping("/delete/+{id}")
    public String delete(@PathVariable Long id) {
        System.out.println("id----------" + id);
        deleteService.delete(id);
        System.out.print("delete 컨트롤러 입니다");
        return "redirect:/board/";
    }

    @PostMapping("/update/+{id}")
    public String update(@PathVariable Long id,
                         UploadForm uploadForm,
                         MultipartHttpServletRequest multipartHttpServletRequest,
                         HttpServletRequest request) throws IOException {
        System.out.println("id값 확인:"+id);
        updateService.update(id,uploadForm, multipartHttpServletRequest);
        return "redirect:/board/";

    }
    @PostMapping("/updateview/+{id}")
    public String updateview(@PathVariable Long id){
        System.out.println("-------업데이트 뷰 입니다-----");
        System.out.println("id값 확인:"+id);
        return "/updatePage";
    }

    @GetMapping("/alerts")
    public String alert(){
        System.out.println("-----------알람 연습 뷰-------");
        return "/alert";
    }




}
