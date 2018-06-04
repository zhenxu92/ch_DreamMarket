package dao.impl;

import java.sql.Connection;

import dao.AuserDAO;
import dao.BuserDAO;
import dao.CartDAO;
import dao.FocusDAO;
import dao.GoodsDAO;
import dao.GoodsPageDAO;
import dao.GoodsTypeDAO;
import dao.NoticeDAO;
import dao.OrderBaseDAO;
import dao.OrderdetailDAO;
import dao.UserBankDAO;
public class DAOFactory {
	public static AuserDAO getAuserDAO(Connection connection){
		return new AuserDAOImpl(connection);
	}
	public static GoodsDAO getGoodsDAO(Connection connection){
		return new GoodsDAOImpl(connection);
	}
	public static GoodsPageDAO getGoodsPageDAO(Connection connection){
		return new GoodsPageDAOImpl(connection);
	}
	public static GoodsTypeDAO getGoodsTypeDAO(Connection connection){
		return new GoodsTypeDAOImpl(connection);
	}
	public static BuserDAO getBuserDAO(Connection connection){
		return new BuserDAOImpl(connection);
	}
	public static OrderBaseDAO getOrderBaseDAO(Connection connection){
		return new OrderBaseDAOImpl(connection);
	}
	public static OrderdetailDAO getOrderdetailDAO(Connection connection){
		return new OrderdetailDAOImpl(connection);
	}
	public static NoticeDAO getNoticeDAO(Connection connection){
		return new NoticeDAOImpl(connection);
	}
	public static FocusDAO getFocusDAO(Connection connection){
		return new FocusDAOImpl(connection);
	}
	public static CartDAO getCartDAO(Connection connection){
		return new CartDAOImpl(connection);
	}
	public static UserBankDAO getUserBankDAO(Connection connection){
		return new UserBankDAOImpl(connection);
	}
}
