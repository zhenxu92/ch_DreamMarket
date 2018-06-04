package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsTypeDAO;
import dao.common.DBUtil;
import dao.entity.GoodsType;



class GoodsTypeDAOImpl implements GoodsTypeDAO {
	private Connection conn;
	
	public GoodsTypeDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public List<GoodsType> select() throws SQLException {
		List<GoodsType> allGoodsType = new ArrayList<GoodsType>();
		GoodsType goodsType = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT typeid, typename FROM goodstype ORDER BY typeid ASC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			goodsType = new GoodsType();
			goodsType.setTypeid(rs.getInt("typeid"));
			goodsType.setTypename(rs.getString("typename"));
			
			allGoodsType.add(goodsType);
		}
		
		rs.close();
		pstmt.close();
		
		return allGoodsType;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		GoodsTypeDAO goodsTypeDAO = new GoodsTypeDAOImpl(conn);
		List<GoodsType> allgGoodsTypes = goodsTypeDAO.select();
		for(GoodsType goodsType : allgGoodsTypes){
			System.out.println(goodsType.getTypeid()+"  "+goodsType.getTypename());
		}
		DBUtil.closeConnection(conn);
	}

}
