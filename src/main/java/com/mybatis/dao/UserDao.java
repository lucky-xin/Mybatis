package com.mybatis.dao;

import com.ssm.po.User;

public interface UserDao {
	public User findUserById(int id);

	public User findUserByName(String name);

	public void insertUser(User user);

	public void deleteUser(int id);

	public void updateUser(User user);

}
