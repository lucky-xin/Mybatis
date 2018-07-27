package com.ssm.po;


import java.util.Date;

/**
 * Created by lucky-xin on 2016/09/13.
 */
public class UserCustom extends User {

    private static final long serialVersionUID = 1L;
    public UserCustom(){}

    public UserCustom(String email, String name, String sex, Date birth, String address, String password) {
        super(email, name, sex, birth, address, password);
    }
}
