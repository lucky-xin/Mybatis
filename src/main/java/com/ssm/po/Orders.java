package com.ssm.po;

import java.sql.Date;
import java.util.List;

public class Orders {
	private String num;
	private int id;
	private int userId;
	private String note;
	private String address;
	private Date createtime;
	private User user;
	private List<Orderdetail> orderdetails;

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Orders [num=" + num + ", id=" + id + ", userId=" + userId
				+ ", note=" + note + ", address=" + address + ", createtime="
				+ createtime + ", user=" + user + ", orderdetails="
				+ orderdetails + "]";
	}

}
