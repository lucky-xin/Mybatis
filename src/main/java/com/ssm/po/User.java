package com.ssm.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lucky-xin on 2016/09/13.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String email;
    private String name;
    private String sex;
    private Date birth;
    private String address;
    private byte[] image;
    private String password;
    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User()
    {
    }

    public User(String email, String name, String sex, Date birth,
                String address, String password) {
        super();
        this.email = email;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password
                + ", email=" + email + ", sex=" + sex + ", birth=" + birth
                + ", address=" + address + "]";
    }


}
