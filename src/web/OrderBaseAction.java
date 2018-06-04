package web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import service.OrderBaseService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.entity.OrderBase;

public class OrderBaseAction extends ActionSupport implements ModelDriven<OrderBase>,ServletResponseAware{
	private HttpServletResponse response;
	public OrderBase getOrderBase() {
		return orderBase;
	}

	public void setOrderBase(OrderBase orderBase) {
		this.orderBase = orderBase;
	}

	/** *  */
	private static final long serialVersionUID = 1L;
	private OrderBase orderBase = new OrderBase();
	public String delete() throws IOException {
		if(orderBase.getOrdersnList() == null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('请选中要删除的订单');</script>");
			response.getWriter().flush(); 
			return INPUT;
		}
		OrderBaseService orderBaseService = ServiceFactory.getOrderBaseService();
		String message = orderBaseService.deleteOrderBase(orderBase);
		if (message == null) {
			return "deleteOrderSuccess";
		}
		return INPUT;
	}

	public OrderBase getModel() {
		// TODO Auto-generated method stub
		return orderBase;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

}
