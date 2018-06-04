package dao.entity;

import java.io.File;
import java.io.Serializable;

public class Goods implements Serializable{
	
	private static final long serialVersionUID = 2356719747715894736L;
	private String gno;
	private String gname;
	private Integer goprice;
	private Integer grprice;
	private Integer gstore;
	private String gpicture;
	private Integer shoppingnum;
	
	private String[] gnoList;
	private GoodsType goodsType;
	
	private File goodsImage;
	private String goodsImageContentType;
	private String goodsImageFileName;
	
	public String getGno() {
		return gno;
	}
	public void setGno(String gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getGoprice() {
		return goprice;
	}
	public void setGoprice(Integer goprice) {
		this.goprice = goprice;
	}
	public Integer getGrprice() {
		return grprice;
	}
	public void setGrprice(Integer grprice) {
		this.grprice = grprice;
	}
	public Integer getGstore() {
		return gstore;
	}
	public void setGstore(Integer gstore) {
		this.gstore = gstore;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(Integer shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
	public String[] getGnoList() {
		return gnoList;
	}
	public void setGnoList(String[] gnoList) {
		this.gnoList = gnoList;
	}
	public File getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(File goodsImage) {
		this.goodsImage = goodsImage;
	}
	public String getGoodsImageContentType() {
		return goodsImageContentType;
	}
	public void setGoodsImageContentType(String goodsImageContentType) {
		this.goodsImageContentType = goodsImageContentType;
	}
	public String getGoodsImageFileName() {
		return goodsImageFileName;
	}
	public void setGoodsImageFileName(String goodsImageFileName) {
		this.goodsImageFileName = goodsImageFileName;
	}
	
	@Override
	public String toString() {
		return "Goods [gname=" + gname + ", gno=" + gno + ", goodsType="
				+ goodsType + ", goprice=" + goprice + ", gpicture=" + gpicture
				+ ", grprice=" + grprice + ", gstore=" + gstore + "]";
	}
	
}
