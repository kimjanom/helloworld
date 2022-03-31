//package com.e2on.testproject.data.service;
//
//import com.e2on.testproject.data.dao.LoginDao;
//import com.e2on.testproject.data.dao.MemberDao;
//import com.e2on.testproject.data.dto.MemberDto;
//import com.e2on.testproject.data.form.MemberForm;
//import com.e2on.testproject.data.manager.SessionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.DatatypeConverter;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.List;
//
//@Service
//public class LoginServiceImpl {
//
////    @Autowired
////    MemberDao dao;
//
//    @Autowired
//    MemberDao dao;
//    @Autowired
//    LoginDao loginDao;
//    @Autowired
//    SessionManager sessionManager;
//
//    public boolean login(MemberForm form,
//                        HttpServletResponse response) throws NullPointerException{
//        String origin = dao.findByEmail(form.getEmail()).getPassword();
//        String pwd = form.getPassword();
//
//        MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        md.update(pwd.getBytes());
//        byte[] digest = md.digest();
//        String myHash = DatatypeConverter
//                .printHexBinary(digest).toUpperCase();
//        if (!myHash.equals(origin)) {
//            return false;
//        }
////        if(loginDao.findByEmailAndPassword(form.getEmail(),form.getPassword())==null){
////            return false;
////        }
//        sessionManager.createSession(form.getEmail(),response);
//        return true;
//
//
//
//
//    }
//}
