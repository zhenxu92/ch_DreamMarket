package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import service.CartService;
import service.GoodsService;
import service.OrderBaseService;
import service.OrderdetailService;
import service.UserBankService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.GetOrdersnOrCurrentTime;
import dao.entity.Goods;
import dao.entity.OrderDetail;
import dao.entity.UserBank;

public class OrderdetailAction extends ActionSupport implements ModelDriven<OrderDetail>,ServletResponseAware,RequestAware,SessionAware{
	/****/
	private static final long serialVersionUID = 1L;
	private OrderDetail orderDetail = new OrderDetail();
	private HttpServletResponse response;
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Goods goods = new Goods();
	private UserBank userBank = new UserBank();
	private Integer bid;
	private Integer amount;

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String addorder() throws IOException{
		userBank.setAccount(orderDetail.getAccount());
		userBank.setAccountpassword(orderDetail.getPassword());
		UserBankService userBankService = ServiceFactory.getUserBankService();
		String message = userBankService.login(userBank);
		if(message!=null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('"+message+"');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		
		int bid = this.getBid();
		String gnoList[] = orderDetail.getGoods().getGnoList();
		Integer []shoppingnumList = orderDetail.getShoppingnumList();
		OrderdetailService orderdetailService = ServiceFactory.getOrderdetailService();
		OrderBaseService orderBaseService = ServiceFactory.getOrderBaseService();
		String ordersn = "E"+GetOrdersnOrCurrentTime.GetOrdersn();
		Integer amount = this.getAmount();
		message = orderBaseService.add(ordersn, bid, amount);
		orderdetailService.add(ordersn, gnoList, shoppingnumList);
		if(message == null){
			message="付款成功，完成支付";
		}
		Integer cidList[] = (Integer [])session.get("cidList");
		if(cidList != null){
			CartService cartService = ServiceFactory.getCartService();
			for(Integer cid:cidList){
				cartService.updateGstoreBycid(cid);
				cartService.deleteGoodsInCartByCid(cid,-1);
			}
		}else if(shoppingnumList.length == 1){
			GoodsService goodsService = ServiceFactory.getGoodsService();
			goodsService.updateGstore(gnoList[0],shoppingnumList[0]);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<script>alert('"+message+"');</script>");
		response.getWriter().flush();
		request.put("ordersn",ordersn);
		return SUCCESS;
	}
	public OrderDetail getModel() {
		return orderDetail;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	
	

}
