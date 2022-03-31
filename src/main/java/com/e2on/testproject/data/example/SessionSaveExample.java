package com.e2on.testproject.data.example;

import com.e2on.testproject.data.dto.MemberDto;
import com.e2on.testproject.data.ustill.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionSaveExample {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
//            transaction.begin();

            MemberDto member=new MemberDto();

            member.setId(1l);
            member.setEmail("aaa@naver.com");
            member.setName("kim");
            member.setPassword("123");
            session.save(member);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        HibernateUtil.shutdown();
    }
    }

