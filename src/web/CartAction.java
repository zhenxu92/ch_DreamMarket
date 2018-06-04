package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import service.CartService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.CountMoney;
import dao.common.IPUtile;
import dao.entity.Buser;
import dao.entity.Cart;
import dao.entity.Goods;
public class CartAction extends ActionSupport implements ModelDriven<Cart>,SessionAware,RequestAware,ServletResponseAware{
	/****/
	private static final long serialVersionUID = -1946277246757389481L;
	Map<String,Object> session;
	Map<String,Object> request;
	private HttpServletResponse response;
	Cart cart = new Cart();
	public Cart getModel() {
		return cart;
	}
	Goods goods = new Goods();
	Buser buser = new Buser();
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Buser getBuser() {
		return buser;
	}
	public void setBuser(Buser buser) {
		this.buser = buser;
	}
	
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	public String updateShoppingnum(){
		CartService cartService = ServiceFactory.getCartService();
		String message = null;
		message = cartService.updateShoppingnum(cart.getCid(), cart.getShoppingnum(), cart.getBuser().getBid());
		request.put("message", message);
		return SUCCESS;
	}
	
	
	public String selectChoisedGoods() throws IOException{
		if(cart.getCidList() == null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('Select items you want to check out.');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		List<Goods> selectChoisedGoodsInCart = new ArrayList<Goods>();
		CartService cartService = ServiceFactory.getCartService();
		Integer cidList[] = cart.getCidList();
		Integer sum = 0;
		cart.setCidList(cidList);
		selectChoisedGoodsInCart = cartService.selectChoisedGoodsInCart(cart);
		for(Goods goods:selectChoisedGoodsInCart){
			Integer amount = goods.getGrprice();
			Integer shoppingnum = goods.getShoppingnum();
			sum = sum+CountMoney.countmoney(shoppingnum, amount);
		}
		session.put("cidList", cidList);
		session.put("goods", selectChoisedGoodsInCart);
		session.put("sum", sum);
		return SUCCESS;
	}
	public String delete(){
		String message = null;
		Buser buser = (Buser)session.get("buser");
		String sessionid = cart.getIp();
		CartService cartService = ServiceFactory.getCartService();
		message = cartService.deleteGoodsInCartByCid(cart.getCid(),buser.getBid());
		if(message == null){
			List<Cart> selectCartGoods = new ArrayList<Cart>();
			sessionid = IPUtile.CreatSessionID(sessionid);
			selectCartGoods = cartService.getCartGoods(buser.getBemail(),sessionid);
			session.put("selectCartGoods", selectCartGoods);
			message = SUCCESS;
		}else{
			message = INPUT;
		}
		return message;
	}
	public String add(){
		String message = null;
		CartService cartService = ServiceFactory.getCartService();
		
		Integer bid = cart.getBuser().getBid();
		String gno = cart.getGoods().getGno();
		String ip = cart.getIp();
		message = cartService.addInCart(cart, bid, gno,ip);
		if(message != null){
			return INPUT;
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('Item added to cart successfully!');</script>");
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
}
