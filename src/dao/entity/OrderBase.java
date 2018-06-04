package dao.entity;

import java.io.Serializable;
import java.sql.Date;

public class OrderBase implements Serializable{

	private static final long serialVersionUID = 2438102679104719988L;
	private String ordersn;
	private Buser buser;
	private Integer amount;
	private String status;
	private Date orderdate;
	private String ordersnList[];
	public String[] getOrdersnList() {
		return ordersnList;
	}
	public void setOrdersnList(String[] ordersnList) {
		this.ordersnList = ordersnList;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public Buser getBuser() {
		return buser;
	}
	public void setBuser(Buser buser) {
		this.buser = buser;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
}
