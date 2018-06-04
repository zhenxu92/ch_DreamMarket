package dao.entity;

import java.io.Serializable;

public class Notice implements Serializable{
	/****/
	private static final long serialVersionUID = -6880647810938472936L;
	private Integer nid;
	private String ntitle;
	private String ncontent;
	private String ntime;
	private Integer[] nidList;

	public Integer[] getNidList() {
		return nidList;
	}
	public void setNidList(Integer[] nidList) {
		this.nidList = nidList;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
}
