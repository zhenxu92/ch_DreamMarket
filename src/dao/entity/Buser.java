package dao.entity;

import java.io.Serializable;

public class Buser implements Serializable{

	private static final long serialVersionUID = -2465592535335537646L;
	private Integer bid;
	private String bemail;
	private String bpwd;
	private String ip;
	
	private Integer bidList[];
	private String sessionid;
	
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer[] getBidList() {
		return bidList;
	}
	public void setBidList(Integer[] bidList) {
		this.bidList = bidList;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	public String getBpwd() {
		return bpwd;
	}
	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}
}
