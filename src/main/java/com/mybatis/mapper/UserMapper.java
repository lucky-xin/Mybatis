package com.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssm.po.Items;
import com.ssm.po.User;
import com.ssm.po.UserCustom;
import com.ssm.po.UserQueryVo;

public interface UserMapper {

	// 用户综合查询
	 List<UserCustom> findUserList(UserQueryVo queryVo) throws Exception;

	// 用户综合查询总数
	 int findUserCount(UserQueryVo queryVo) throws Exception;

	 User findUserByResultMap(int id) throws Exception;

	 User findUserById(int id) throws Exception;

	 List<User> findUserByName(String name) throws Exception;

	 void insertUser(User user) throws Exception;

	 void deleteUser(int id) throws Exception;

	 void updateUser(User user) throws Exception;

	List<User> findUserByHashMap(HashMap<String, Object> map)throws Exception;

}
