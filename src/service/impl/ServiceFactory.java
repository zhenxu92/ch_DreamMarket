package service.impl;

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

public class ServiceFactory {
	public static AuserService getAuserService(){
		return new AuserServiceImpl();
	}
	public static GoodsService getGoodsService(){
		return new GoodsServiceImpl();
	}
	public static GoodsPageService getGoodsPageService(){
		return new GoodsPageServiceImpl();
	}
	public static GoodsTypeService getGoodsTypeService(){
		return new GoodsTypeServiceImpl();
	}
	public static BuserService getBuserService(){
		return new BuserServiceImpl();
	}
	public static OrderBaseService getOrderBaseService(){
		return new OrderBaseServiceImpl();
	}
	public static OrderdetailService getOrderdetailService(){
		return new OrderdetailServiceImpl();
	}
	public static NoticeService getNoticeService(){
		return new NoticeServiceImpl();
	}
	public static FocusService getFocusService(){
		return new FocusServiceImpl();
	}
	public static CartService getCartService(){
		return new CartServiceImpl();
	}
	public static UserBankService getUserBankService(){
		return new UserBankServiceImpl();
	}
}
