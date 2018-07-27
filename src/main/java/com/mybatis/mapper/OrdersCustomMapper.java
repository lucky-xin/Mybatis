package com.mybatis.mapper;

import java.util.List;

import com.ssm.po.Orders;
import com.ssm.po.OrdersCustom;
import com.ssm.po.User;

public interface OrdersCustomMapper {
	// 查询订单关联查询用户
	 List<OrdersCustom> findOrdersUser() throws Exception;

	 List<Orders> findOrdersUserResultMap() throws Exception;

	// 查询订单(关联用户)及订单明细
	 List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;

	// 查询用户购买商品信息
	 List<User> findUserAndItemsResultMap() throws Exception;

	// 延时加载
	 List<Orders> findOrdresUserLazyLoading() throws Exception;

}
