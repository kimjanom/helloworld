package com.e2on.testproject.data.form;

import com.e2on.testproject.data.dao.LoginDao;
import com.e2on.testproject.data.dto.MemberDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class MemberForm {
    private String password;
    private String name;
    private String email;

}
