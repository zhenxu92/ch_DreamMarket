package dao.entity;

import java.io.Serializable;

public class GoodsType implements Serializable{

	private static final long serialVersionUID = 5282190740957484216L;
	private Integer typeid;
	private String typename;
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
