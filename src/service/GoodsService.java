package service;

import java.util.List;

import dao.entity.Goods;
public interface GoodsService {
	String add(Goods goods);
	List<Goods> selectGoods();
	int update(Goods goods);
	List<Goods> vagueGetGoods(String gname,Integer typeid);
	String deleteGoods(Goods goods);
	Goods selectGoodsDetails(String gno);
	List<Goods> selectChoisedGoods(Goods goods);
	String selectGno(String gno);
	String updateGstore(String gno,Integer shoppingnum);
}
