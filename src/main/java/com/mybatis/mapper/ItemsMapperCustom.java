package com.mybatis.mapper;

import java.util.List;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;
}