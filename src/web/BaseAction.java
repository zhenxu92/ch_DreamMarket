package web;



import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import service.AuserService;
import service.BuserService;
import service.CartService;
import service.FocusService;
import service.GoodsPageService;
import service.GoodsService;
import service.GoodsTypeService;
import service.NoticeService;
import service.OrderBaseService;
import service.OrderdetailService;
import service.UserBankService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware,ServletContextAware{
	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected ServletContext sContext;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext sContext) {
		this.sContext = sContext;
	}
	/*** 1.ModelDriven的支�? ***/
	protected Map<String, Object> map = new HashMap<String, Object>();

	public Map<String, Object> getMap() {
		return map;
	}
	// 封装对象，用于接收参数，参数类型为该对象�?
	protected T model;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			// Reflection to get class
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// Reflection to get instance
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	/*** 2.Services ****/
	protected AuserService auserService = ServiceFactory.getAuserService();
	protected BuserService buserService = ServiceFactory.getBuserService();
	protected GoodsService goodsService = ServiceFactory.getGoodsService();
	protected GoodsTypeService goodsTypeService = ServiceFactory.getGoodsTypeService();
	protected CartService cartService = ServiceFactory.getCartService();
	protected OrderBaseService orderBaseService = ServiceFactory.getOrderBaseService();
	protected OrderdetailService orderdetailService = ServiceFactory.getOrderdetailService();
	protected GoodsPageService goodsPageService = ServiceFactory.getGoodsPageService();
	protected FocusService focusService = ServiceFactory.getFocusService();
	protected NoticeService noticeService = ServiceFactory.getNoticeService();
	protected UserBankService userBankService = ServiceFactory.getUserBankService();
	
	
}
