package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.Goods;
public interface GoodsPageDAO {
	List<Goods> PagingSelect(int startIndex, int endIndex) throws SQLException;
	int GoodsCountingSelect() throws SQLException;
	List<Goods> PagingSelectByGnameOrType(int startIndex, int endIndex,String gname,Integer typeid) throws SQLException;
	int GoodsCountingSelectByGnameOrType(String gname,Integer typeid) throws SQLException;
}
