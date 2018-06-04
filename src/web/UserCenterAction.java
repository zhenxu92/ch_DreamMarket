package web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.CartService;
import service.FocusService;
import service.OrderdetailService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.IPUtile;
import dao.entity.Cart;
import dao.entity.Focus;
import dao.entity.Buser;
import dao.entity.Goods;
import dao.entity.OrderBase;
import dao.entity.OrderDetail;

public class UserCenterAction extends ActionSupport implements ModelDriven<Buser>, SessionAware{
/****/
	private static final long serialVersionUID = -674490248929584762L;
	private Map<String,Object> session;
	private Focus focus = new Focus();
	private Buser buser = new Buser();
	private Goods goods = new Goods();
	private OrderBase orderBase = new OrderBase();
	private Cart cart = new Cart();
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Focus getFocus() {
		return focus;
	}
	public void setFocus(Focus focus) {
		this.focus = focus;
	}
	public Buser getBuser() {
		return buser;
	}
	public void setBuser(Buser buser) {
		this.buser = buser;
	}

	public OrderBase getOrderBase() {
		return orderBase;
	}
	public void setOrderBase(OrderBase orderBase) {
		this.orderBase = orderBase;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	public Buser getModel() {
		// TODO Auto-generated method stub
		return buser;
	}
	public String init(){
		FocusService focusService = ServiceFactory.getFocusService();
		String bemail = buser.getBemail();
		OrderdetailService orderdetailService = ServiceFactory.getOrderdetailService();
		List<Focus> FocusGoods = focusService.getFocusGood(bemail);
		List<OrderDetail> selectOrderdetail = orderdetailService.selectOrderdetails(buser.getBid());
		session.put("FocusGoods", FocusGoods);
		session.put("selectOrderdetail", selectOrderdetail);
		return SUCCESS;
	}
	public String initCartGoods(){
		List<Cart> selectCartGoods = new ArrayList<Cart>();
		CartService cartService = ServiceFactory.getCartService();
		String sessionid = buser.getSessionid();
		sessionid = IPUtile.CreatSessionID(sessionid);
		selectCartGoods = cartService.getCartGoods(buser.getBemail(),sessionid);
		session.put("selectCartGoods", selectCartGoods);
		return SUCCESS;
	}
}
