package com.ssm.po;

public class Orderdetail {
	private int ordersId;
	private int itemsId;
	private int id;
	private int itemsNum;
	private Items items;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}

}
