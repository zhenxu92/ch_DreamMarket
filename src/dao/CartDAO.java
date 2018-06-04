package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.Cart;
import dao.entity.Goods;

public interface CartDAO {
	int insert(Cart cart,Integer bid,String gno,String ip) throws SQLException;
	List<Cart> selectCart(String bemail,String sessionid) throws SQLException;
	int deleteGoodsInCartByID(Integer cid,Integer bid) throws SQLException;
	List<Goods> selectChoisedGoodsInCart(Cart cart) throws SQLException;
	int updateShoppingnum(Integer cid,Integer shoppingnum,Integer bid) throws SQLException;
	int updateGstoreBycid(Integer cid) throws SQLException;
}
