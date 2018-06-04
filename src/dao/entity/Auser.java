package dao.entity;

import java.io.Serializable;

public class Auser implements Serializable {

	
	private static final long serialVersionUID = 8641317384689435600L;

	private String aname;
	private String apwd;
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	
}
