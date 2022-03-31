package com.e2on.testproject.data.dto;


import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.prefs.Preferences;

@Data
@Entity
@RequiredArgsConstructor
public class MemberDto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, length= 60)
    private String password;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String email;

    public MemberDto(Long id, String password, String name, String email) {
    }







}
