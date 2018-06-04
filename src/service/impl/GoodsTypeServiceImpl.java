package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.GoodsTypeDAO;
import dao.common.DBUtil;
import dao.entity.GoodsType;
import dao.impl.DAOFactory;
import service.GoodsTypeService;

class GoodsTypeServiceImpl implements GoodsTypeService {

	public List<GoodsType> getAllGoodsType() {
		List<GoodsType> allgGoodsTypes = null;
		Connection connection = DBUtil.getConnection();
		GoodsTypeDAO goodsTypeDAO = DAOFactory.getGoodsTypeDAO(connection);
		
		try {
			allgGoodsTypes = goodsTypeDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return allgGoodsTypes;
	}

}
