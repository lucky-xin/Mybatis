package com.mybatis.mapper;

import java.util.List;

import com.mybatis.utils.MySqlSessionFactory;
import com.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ssm.po.Orders;
import com.ssm.po.OrdersCustom;

public class OrdersCustomMapperTest {
	static SqlSession sqlSession = null;
	private static OrdersCustomMapper customMapper = null;

	static {
		sqlSession = MySqlSessionFactory.openSqlSession();
		customMapper = sqlSession.getMapper(OrdersCustomMapper.class);
	}


	@Test
	public void testFindOdersUser() throws Exception {
		List<OrdersCustom> customs = customMapper.findOrdersUser();
		System.out.println(customs.size()+"---------"+customs);
	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		List<Orders> customs = customMapper.findOrdersUserResultMap();
		System.out.println(customs);
		System.out.println(customs.get(0).getUser());
	}

	@Test
	public void testFindOrdersAndOrderdetailResultMap() throws Exception {
		List<Orders> customs = customMapper.findOrdersAndOrderdetailResultMap();
		System.out.println(customs);
	}

	@Test
	public void testFindfindUserAndItemsResultMap() throws Exception {
		List<User> customs = customMapper.findUserAndItemsResultMap();
		System.out.println(customs);
	}

	@Test
	public void testFindOrdresUserLazyLoading() throws Exception {
		// 执行select *from user_tbl where id=?
		List<Orders> list = customMapper.findOrdresUserLazyLoading();

		for (Orders orders : list) {
			// 执行select *from user_tbl where id=?
			User user = orders.getUser();// 延时加载
			System.out.println(user);
		}
	}

}
