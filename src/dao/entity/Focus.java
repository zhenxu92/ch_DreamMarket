package dao.entity;

import java.io.Serializable;

public class Focus implements Serializable{
	/****/
	private static final long serialVersionUID = 6534426115680139342L;
	private Integer fid;
	private Buser buser;
	private Goods goods;
	private String focustime;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
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
	public String getFocustime() {
		return focustime;
	}
	public void setFocustime(String focustime) {
		this.focustime = focustime;
	}
}
