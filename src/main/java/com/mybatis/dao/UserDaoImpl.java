package com.mybatis.dao;

import com.mybatis.utils.JdbcUtils;
import com.mybatis.utils.MySqlSessionFactory;
import com.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl implements UserDao {
	private static SqlSessionFactory factory = MySqlSessionFactory.getSqlSessionFactory();


	public User findUserById(int id) {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = factory.openSession();
			user = sqlSession.selectOne("test.findUserById", id);
		} finally {
			JdbcUtils.free(sqlSession);
		}
		return user;
	}

	public void insertUser(User user) {
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession();
			if (sqlSession == null) {
				return;
			}
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		} finally {
			JdbcUtils.free(sqlSession);
		}

	}

	public void deleteUser(int id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession();
			sqlSession.delete("test.deleteUser", id);
			sqlSession.commit();
		} finally {
			JdbcUtils.free(sqlSession);
		}

	}

	public void updateUser(User user) {
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession();
			sqlSession.update("test.updateUser", user);
			sqlSession.commit();
		} finally {
			JdbcUtils.free(sqlSession);
		}

	}

	public User findUserByName(String name) {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = factory.openSession();
			user = sqlSession.selectOne("test.findUserByName", name);
			sqlSession.commit();
		} finally {
			JdbcUtils.free(sqlSession);
		}
		return user;
	}

}
