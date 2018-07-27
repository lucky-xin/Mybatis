package com.mybatis.utils;

import org.apache.ibatis.session.SqlSession;

public class JdbcUtils {
	public static void free(SqlSession sqlSession) {
		if (sqlSession != null) {
			try {
				sqlSession.close();
			} catch (Exception e) {
			}
		}
	}
}
