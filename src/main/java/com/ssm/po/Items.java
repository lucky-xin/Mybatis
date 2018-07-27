package com.ssm.po;


import java.util.Date;
import java.util.List;

public class Items {
	// 校验名称在1到30字符中间
	// message是提示校验出错显示的信息
	// groups：此校验属于哪个分组，groups可以定义多个分组
	private String name;
	private Integer id;
	private int price;
	private String detail;
	private String pic;
	// 非空校验
	private Date createtime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
