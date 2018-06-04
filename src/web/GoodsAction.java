package web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import service.FocusService;
import service.GoodsService;
import service.GoodsTypeService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.CountMoney;
import dao.entity.Goods;
import dao.entity.GoodsType;

public class GoodsAction extends ActionSupport implements ModelDriven<Goods>,
		ServletResponseAware, RequestAware,SessionAware {
	private static final long serialVersionUID = 4643431355818454048L;
	private Goods goods = new Goods();
	private Map<String, Object> request;
	private Map<String, Object> session;
	private HttpServletResponse response;
	private String gno;
	private GoodsType goodsType = null;
	private Integer bid;
	private Integer shoppingnum;
	private Integer amount;
	
	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public Integer getShoppingnum() {
		return shoppingnum;
	}

	public void setShoppingnum(Integer shoppingnum) {
		this.shoppingnum = shoppingnum;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Goods getModel() {
		return goods;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	
	public String selectGno(){
		GoodsService goodsService = ServiceFactory.getGoodsService();
		String message = null;
		message = goodsService.selectGno(gno);
		System.out.println(message);
		System.out.println(gno);
		request.put("message", message);
		return SUCCESS;
	}
	
	public String vagueselect() {
		GoodsService goodsService = ServiceFactory.getGoodsService();
		List<Goods> vagueselectGoods = goodsService.vagueGetGoods(goods
				.getGname(), goodsType.getTypeid());
		request.put("vagueselectGoods", vagueselectGoods);
		return SUCCESS;
	}

	public String updateGoods() throws IOException {
		/*File file = new File("E:\\javaweb代码\\.metadata\\.me_tcat\\webapps\\ch_DreamMarket\\GoodsImages");
		String s = goods.getGno();
		goods.setGoodsImageFileName(s + ".jpg");
		try {
			FileUtils.copyFile(goods.getGoodsImage(), new File(file, goods
					.getGoodsImageFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		goods.setGpicture("/ch_DreamMarket/GoodsImages/" + s + ".jpg");*/
		GoodsService goodsService = ServiceFactory.getGoodsService();
		int result = goodsService.update(goods);
		
		if (result == 1) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('商品修改成功！');</script>");
			response.getWriter().flush();
			return "updateGoodsSuccess";
		} else {
			return INPUT;
		}
	}

	public String deleteGoods() throws IOException {
		if(goods.getGnoList() == null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('请选中要删除的商品');</script>");
			response.getWriter().flush(); 
			return INPUT;
		}
		GoodsService goodsService = ServiceFactory.getGoodsService();
		String message2 = goodsService.deleteGoods(goods);
		if (message2 != null) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('"+message2+"');</script>");
			response.getWriter().flush(); 
			return INPUT;
		}
		return "deleteGoodsSuccess";
	}

	public String selectGoodsDetails() {
		GoodsTypeService goodsTypeService = ServiceFactory.getGoodsTypeService();
		List<GoodsType> allGoodsTypes = goodsTypeService.getAllGoodsType(); 
		session.put("allGoodsTypes", allGoodsTypes);
		
		GoodsService goodsService = ServiceFactory.getGoodsService();
		
		String gno = goods.getGno();
		
		this.shoppingnum = goods.getShoppingnum();
		Integer sum = CountMoney.countmoney(this.getShoppingnum(), this.getAmount());
		goods = goodsService.selectGoodsDetails(gno);
		goods.setShoppingnum(this.getShoppingnum());
		session.put("goods", goods);
		session.put("sum", sum);
		return SUCCESS;
	}

	public String addGoods() throws IOException {
		// String realpath =
		// ServletActionContext.getServletContext().getRealPath();
		System.out.println(goods.getGno()+""+140450734);
		if(goods.getGno().equals("")){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('请输入商品编号');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		if(goods.getGrprice() == null||goods.getGoprice() == null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('请输入商品价格');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		GoodsService goodsService = ServiceFactory.getGoodsService();
		String s = goods.getGno();
		goods.setGpicture("/ch_DreamMarket/GoodsImages/" + s + ".jpg");
		
		String message = goodsService.add(goods);
		if (message == null) {
			File file = new File("E:\\javaweb代码\\.metadata\\.me_tcat7\\webapps\\ch_DreamMarket\\GoodsImages");
			
			goods.setGoodsImageFileName(s + ".jpg");
			try {
				FileUtils.copyFile(goods.getGoodsImage(), new File(file, goods
						.getGoodsImageFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "addGoodsSuccess";
		} else {
			
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('"+message+"');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		
	}
	public String vagueGetGoods(){
		List<Goods> vagueselectGoods = new ArrayList<Goods>();
		GoodsService goodsService = ServiceFactory.getGoodsService();
		vagueselectGoods = goodsService.vagueGetGoods(goods.getGname(), goods.getGoodsType().getTypeid());
		session.put("vagueselectGoods", vagueselectGoods);
		return SUCCESS;
	}
	
	
	public String addfocusgood() throws IOException{
		String gno = goods.getGno();
		int bid = this.getBid();
		FocusService focusService = ServiceFactory.getFocusService();
		String message = focusService.add(bid, gno);
		if (message == null) {

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('商品添加成功');</script>");
			response.getWriter().flush(); 
			return SUCCESS;
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('"+message+"');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		
		
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}
	/*
	 * public int getDisplayGoodsDetailsFlag() { return displayGoodsDetailsFlag;
	 * } public void setDisplayGoodsDetailsFlag(int displayGoodsDetailsFlag) {
	 * this.displayGoodsDetailsFlag = displayGoodsDetailsFlag; }
	 */

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
