package web.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import service.GoodsPageService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.common.Page;
import dao.common.PageResult;
import dao.common.PageUtil;
import dao.entity.Goods;

public class GoodsPageActionForm extends ActionSupport implements ModelDriven<Goods>,SessionAware,Serializable,RequestAware{

	private static final long serialVersionUID = 5892163337031102799L;
	private int currentPage;
	private boolean target;
	private Map<String,Object> session;
	private Goods goods = new Goods();
	public boolean isTarget() {
		return target;
	}
	public void setTarget(boolean target) {
		this.target = target;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	public Goods getModel() {
		return goods;
	}
	public String PageOnChange(){
		GoodsPageService goodsPageService = ServiceFactory.getGoodsPageService();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page = PageUtil.getPage(page.getPageRecord(), page.getCurrentPage(),goodsPageService.GoodsCountingSelect());
		List<Goods> selectGoods = goodsPageService.PagingSelect(page.getStartIndex(), page.getEndIndex());
		PageResult pageResult = new PageResult(page, selectGoods);
		session.put("pageResult", pageResult);
		// save total #pages and current #page
		session.put("totalPage", page.getTotalPage());
		session.put("currentPage", page.getCurrentPage());
		
		session.put("selectGoods", selectGoods);
		return SUCCESS;
	}
	public String SelectByGnameOrType(){
		this.target = false;
		GoodsPageService goodsPageService = ServiceFactory.getGoodsPageService();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page = PageUtil.getPage(page.getPageRecord(), page.getCurrentPage(),goodsPageService.GoodsCountSelectByGnameOrType(goods.getGname(),goods.getGoodsType().getTypeid()));
		List<Goods> selectGoods = goodsPageService.PagingSelectByGnameOrType(page.getStartIndex(), page.getEndIndex(),goods.getGname(),goods.getGoodsType().getTypeid());
		PageResult pageResult = new PageResult(page, selectGoods);
		session.put("pageResult", pageResult);
		// 保存总页数和当前页数
		session.put("totalPage", page.getTotalPage());
		session.put("currentPage", page.getCurrentPage());
		session.put("vagueselectGoods", selectGoods);
		session.put("gname", goods.getGname());
		session.put("typeid", goods.getGoodsType().getTypeid());
		if(0 != selectGoods.size()){
			this.setTarget(true);
		}
		session.put("target", this.target);
		return SUCCESS;
	}
	public void setRequest(Map<String, Object> arg0) {
	}
}
