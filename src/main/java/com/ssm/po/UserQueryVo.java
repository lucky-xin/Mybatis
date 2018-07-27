package com.ssm.po;


import java.util.List;

/**
 * Created by lucky-xin on 2016/09/13.
 */
public class UserQueryVo {

    private List<Integer> ids;

    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}