package com.mybatis.test;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.UserDaoImpl;
import com.mybatis.mapper.UserMapper;
import com.ssm.po.User;
import org.junit.Test;

import java.sql.Date;

public class MyBitesTest2 {
	private UserDao userDao = new UserDaoImpl();

	@Test
	public void testDate() {
		
		java.util.Date date1 = new java.util.Date(2014,03,04);
		System.out.println(date1.getYear());
		Date date=new Date(2014, 3, 5);
		System.out.println(date.getYear()+" "+date.getMonth()+" "+date.getDate());

	}

	@Test
	public void updateUser() {

		User user = new User("jj@qq.com", "林俊杰", "男", new Date(20121212),
				"新加坡", "Tencent");
		user.setId(16);
		userDao.updateUser(user);
	}

	@Test
	public void deleteUser() {
		userDao.deleteUser(4);

	}

	@Test
	public void insertUser() {

		User user = new User("贾跃亭@qq.com", "贾跃亭", "男", new Date(2016, 5, 7),
				"北京", "贾跃亭");
		userDao.insertUser(user);
	}

	@Test
	public void findUserByName() {
		User user = userDao.findUserById(44);
		System.out.println(user.getName());
	}

	@Test
	public void findUserById() throws Exception {
		User user = userDao.findUserById(1);
		System.out.println(user.getName());
	}
}
