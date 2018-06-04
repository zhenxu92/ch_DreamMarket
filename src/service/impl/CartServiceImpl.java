package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.CartService;
import dao.common.DBUtil;
import dao.entity.Cart;
import dao.entity.Goods;
import dao.impl.DAOFactory;

class CartServiceImpl implements CartService {

	public List<Cart> getCartGoods(String bemail,String sessionid) {
		List<Cart> selectCartGoods = null;
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		try {
			selectCartGoods = cartDAO.selectCart(bemail,sessionid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectCartGoods;
		}

	public String addInCart(Cart cart,Integer bid,String gno,String ip) {
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		String message = null;
		try {
			int result = cartDAO.insert(cart,bid,gno,ip);
			if(result == 0){
				message = "Failed to add to cart.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Server busy";
		}
		return message;
	}

	public String deleteGoodsInCartByCid(Integer cid,Integer bid) {
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		String message = null;
		try {
			int result = cartDAO.deleteGoodsInCartByID(cid,bid);			
			if(result == 0){
				message = "Failed to ";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Server busy";
		}
		return message;
		
	}

	public List<Goods> selectChoisedGoodsInCart(Cart cart) {
		List<Goods> selectChoisedGoodsInCart = null;
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		try {
			selectChoisedGoodsInCart = cartDAO.selectChoisedGoodsInCart(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectChoisedGoodsInCart;
	}

	public String updateShoppingnum(Integer cid, Integer shoppingnum,Integer bid) {
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		String message = null;
		try {
			int result = cartDAO.updateShoppingnum(cid, shoppingnum,bid);
			if(result == 0){
				message = "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	public String updateGstoreBycid(Integer cid) {
		Connection connection = DBUtil.getConnection();
		CartDAO cartDAO = DAOFactory.getCartDAO(connection);
		String message = null;
		try {
			int result = cartDAO.updateGstoreBycid(cid);
			if(result == 0){
				message = "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
}
