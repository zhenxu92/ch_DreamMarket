package web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.GoodsPageService;
import service.GoodsTypeService;
import service.NoticeService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.Page;
import dao.common.PageResult;
import dao.common.PageUtil;
import dao.entity.Buser;
import dao.entity.Goods;
import dao.entity.GoodsType;
import dao.entity.Notice;
public class HomePageAction extends ActionSupport implements ModelDriven<Goods>, SessionAware{
	/****/
	private static final long serialVersionUID = 6428216600651490833L;
	
	private Goods goods = new Goods();
	private Buser buser = null;
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	private GoodsType goodsType = null;
	private Map<String,Object> session;
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
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

	public String init(){
		//GoodsService goodsService = ServiceFactory.getGoodsService();
		GoodsTypeService goodsTypeService = ServiceFactory.getGoodsTypeService();
		NoticeService noticeService = ServiceFactory.getNoticeService();
		GoodsPageService goodsPageService = ServiceFactory.getGoodsPageService();
		
		List<GoodsType> allGoodsTypes = goodsTypeService.getAllGoodsType(); 
		List<Notice> allNotice = noticeService.getNotice();
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page = PageUtil.getPage(page.getPageRecord(), page.getCurrentPage(),goodsPageService.GoodsCountingSelect());
		List<Goods> selectGoods = goodsPageService.PagingSelect(page.getStartIndex(), page.getEndIndex());
		PageResult pageResult = new PageResult(page, selectGoods);
		Buser buser = (Buser)session.get("buser");
		if(buser==null){
			buser = new Buser();
			buser.setBemail("You");
			buser.setBid(0);
			session.put("buser", buser);
		}
		session.put("pageResult", pageResult);

		// save total #pages and current #page
		session.put("totalPage", page.getTotalPage());
		session.put("currentPage", page.getCurrentPage());
		
		session.put("selectGoods", selectGoods);
		session.put("allGoodsTypes", allGoodsTypes);
		session.put("allNotice", allNotice);
		return SUCCESS;
	}
	
	public Goods getModel() {
		return goods;
	}
	
}
