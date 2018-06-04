package dao.entity;

import java.io.Serializable;

public class UserBank implements Serializable{
	/****/
	private static final long serialVersionUID = 5851109782457505314L;
	private String account;
	private String accountpassword;
	private Integer bid;
	private Integer money;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountpassword() {
		return accountpassword;
	}
	public void setAccountpassword(String accountpassword) {
		this.accountpassword = accountpassword;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
