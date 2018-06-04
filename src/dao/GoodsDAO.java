package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.Goods;
public interface GoodsDAO {
	boolean selectGno(String gno) throws SQLException;
	int insert(Goods goods) throws SQLException;
	List<Goods> select() throws SQLException;
	Goods selectGoodsDetails(String gno) throws SQLException;
	List<Goods> select2(String gname,Integer typeid) throws SQLException;
	int update(Goods goods) throws  SQLException;
	int deleteGoods(Goods goods) throws  SQLException;
	List<Goods> selectChoisedGoods(Goods goods) throws SQLException;
	int updateGstore(String gno,Integer shoppingnum) throws SQLException;
}
