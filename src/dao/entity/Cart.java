package dao.entity;

import java.io.Serializable;

public class Cart implements Serializable{

	private static final long serialVersionUID = -6359928430738258263L;
	private Integer cid;
	private Buser buser;
	private Goods goods;
	private Integer shoppingnum;
	private Integer cidList[];
	 
	private String ip;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer[] getCidList() {
		return cidList;
	}
	public void setCidList(Integer[] cidList) {
		this.cidList = cidList;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Buser getBuser() {
		return buser;
	}
	public void setBuser(Buser buser) {
		this.buser = buser;
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
