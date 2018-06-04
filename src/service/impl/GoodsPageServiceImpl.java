package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.GoodsPageService;
import dao.GoodsPageDAO;
import dao.common.DBUtil;
import dao.entity.Goods;
import dao.impl.DAOFactory;

public class GoodsPageServiceImpl implements GoodsPageService {

	public List<Goods> PagingSelect(int startIndex, int endIndex) {
		List<Goods> selectGoods = null;
		Connection connection = DBUtil.getConnection();
		GoodsPageDAO GoodsPageDAO = DAOFactory.getGoodsPageDAO(connection);
		try {
			selectGoods = GoodsPageDAO.PagingSelect(startIndex, endIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectGoods;
	}

	public int GoodsCountingSelect() {
		Connection connection = DBUtil.getConnection();
		GoodsPageDAO GoodsPageDAO = DAOFactory.getGoodsPageDAO(connection);
		int goodscounting = 0;
		try {
			goodscounting = GoodsPageDAO.GoodsCountingSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return goodscounting;
	}

	public List<Goods> PagingSelectByGnameOrType(int startIndex, int endIndex,
			String gname, Integer typeid) {
		List<Goods> selectGoods = null;
		Connection connection = DBUtil.getConnection();
		GoodsPageDAO GoodsPageDAO = DAOFactory.getGoodsPageDAO(connection);
		try {
			selectGoods = GoodsPageDAO.PagingSelectByGnameOrType(startIndex, endIndex, gname, typeid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectGoods;
	}

	public int GoodsCountSelectByGnameOrType(String gname, Integer typeid) {
		Connection connection = DBUtil.getConnection();
		GoodsPageDAO GoodsPageDAO = DAOFactory.getGoodsPageDAO(connection);
		int goodscounting = 0;
		try {
			goodscounting = GoodsPageDAO.GoodsCountingSelectByGnameOrType(gname, typeid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return goodscounting;
	}

}
