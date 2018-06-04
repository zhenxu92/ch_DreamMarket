package web;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import service.BuserService;
import service.GoodsService;
import service.GoodsTypeService;
import service.NoticeService;
import service.OrderBaseService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

import dao.entity.Goods;
import dao.entity.GoodsType;
import dao.entity.Buser;
import dao.entity.OrderBase;
import dao.entity.Notice;
public class ManageAction extends ActionSupport implements SessionAware{
	/****/
	private static final long serialVersionUID = 6428216600651490833L;
	private GoodsType goodsType = new GoodsType();
	private Goods goods = new Goods();
	private Buser buser = new Buser();
	private Notice notice = new Notice();
	private Map<String,Object> session;
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
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
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public String init(){
		GoodsTypeService goodsTypeService = ServiceFactory.getGoodsTypeService();
		GoodsService goodsService = ServiceFactory.getGoodsService();
		BuserService buserService = ServiceFactory.getBuserService();
		OrderBaseService orderBaseService = ServiceFactory.getOrderBaseService();
		NoticeService noticeService = ServiceFactory.getNoticeService();
		List<GoodsType> allGoodsTypes = goodsTypeService.getAllGoodsType(); 
		List<Goods> selectGoods = goodsService.selectGoods();
		List<Buser> allBuser = buserService.getBusers();
		List<OrderBase> allOrder = orderBaseService.getAllOrder();
		List<Notice> allNotice = noticeService.getNotice();
		session.put("allGoodsTypes", allGoodsTypes);
		session.put("selectGoods", selectGoods);
		session.put("allBuser", allBuser);
		session.put("allOrder", allOrder);
		session.put("allNotice", allNotice);
		return SUCCESS;
	}
	
}
