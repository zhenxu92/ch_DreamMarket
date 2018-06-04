package service;

import java.util.List;

import dao.entity.Cart;
import dao.entity.Goods;

public interface CartService {
	List<Cart> getCartGoods(String gname,String sessionid);
	String addInCart(Cart cart,Integer bid,String gno,String ip);
	String deleteGoodsInCartByCid(Integer cid,Integer bid);
	List<Goods> selectChoisedGoodsInCart(Cart cart);
	String updateShoppingnum(Integer cid,Integer shoppingnum,Integer bid);
	String updateGstoreBycid(Integer cid);
}
