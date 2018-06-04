package dao.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	/****/
	private static final long serialVersionUID = -3440978380602531828L;
	private OrderBase orderBase;
	private Goods goods;
	private Integer shoppingnum;
	private Integer []shoppingnumList;
	
	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer[] getShoppingnumList() {
		return shoppingnumList;
	}
	public void setShoppingnumList(Integer[] shoppingnumList) {
		this.shoppingnumList = shoppingnumList;
	}
	public OrderBase getOrderBase() {
		return orderBase;
	}
	public void setOrderBase(OrderBase orderBase) {
		this.orderBase = orderBase;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(Integer shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
}
