package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsPageDAO;
import dao.common.DBUtil;
import dao.entity.Goods;
import dao.entity.GoodsType;

class GoodsPageDAOImpl implements GoodsPageDAO{
	private Connection conn;
	public GoodsPageDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public List<Goods> PagingSelect(int startIndex, int endIndex) throws SQLException {
		String sql = "		 	SELECT gno,gname,goprice,grprice,gstore,gpicture,"  
			+ "							  goodstype.typeid,typename " 
			+ "					FROM   goodstype,goodstable " 
			+ "			        WHERE goodstype.typeid=goodstable.typeid " 
			+ "					ORDER BY gno ASC LIMIT ?,?;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startIndex);
		pstmt.setInt(2, endIndex);

		rs = pstmt.executeQuery();
		List<Goods> selectGoods = new ArrayList<Goods>();
		Goods goods = null;
		GoodsType goodsType = null;
		while(rs.next()) {
			goods = new Goods();
			goods.setGno(rs.getString(1));
			goods.setGname(rs.getString(2));
			goods.setGoprice(rs.getInt(3));
			goods.setGrprice(rs.getInt(4));
			goods.setGstore(rs.getInt(5));
			goods.setGpicture(rs.getString(6));
			goodsType = new GoodsType();
			goodsType.setTypeid(rs.getInt(7));
			goodsType.setTypename(rs.getString(8));
			goods.setGoodsType(goodsType);
			selectGoods.add(goods);
		}
		rs.close();
		pstmt.close();
		return selectGoods;
	}
	public int GoodsCountingSelect() throws SQLException {

		int GoodsCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT count(1) AS recordcount FROM goodstable";

		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			GoodsCount = rs.getInt("recordcount");
		}

		rs.close();
		pstmt.close();
		
		return GoodsCount;

	}
	public List<Goods> PagingSelectByGnameOrType(int startIndex, int endIndex,
			String gname, Integer typeid) throws SQLException {
		String sql = null;
		if("".equals(gname)){
			gname = null;
		}
		if(gname == null&&typeid == null){
			sql	= "SELECT goodstable.gno,goodstable.gname,goodstable.goprice," +
					"goodstable.grprice,goodstable.gstore,goodstable.gpicture," +
					"goodstype.typeid,goodstype.typename FROM " +
					"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
					"ORDER BY goodstype.typeid ASC";
		}else if(gname != null&&typeid == null){
			sql	= "SELECT goodstable.gno,goodstable.gname,goodstable.goprice," +
			"goodstable.grprice,goodstable.gstore,goodstable.gpicture," +
			"goodstype.typeid,goodstype.typename FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND gname LIKE '%" + gname + "%' ORDER BY goodstype.typeid ASC";
		}else if(gname == null&&typeid != null){
			sql	= "SELECT goodstable.gno,goodstable.gname,goodstable.goprice," +
			"goodstable.grprice,goodstable.gstore,goodstable.gpicture," +
			"goodstype.typeid,goodstype.typename FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND goodstype.typeid = " + typeid + " ORDER BY goodstype.typeid ASC";
		}else{
			sql	= "SELECT goodstable.gno,goodstable.gname,goodstable.goprice," +
			"goodstable.grprice,goodstable.gstore,goodstable.gpicture," +
			"goodstype.typeid,goodstype.typename FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND gname LIKE '%" + gname + "%' AND goodstype.typeid = " + typeid +
					" ORDER BY goodstype.typeid ASC";
		}
		String selectsql =sql + " LIMIT ?,?;";
				
		
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, endIndex);

			rs = pstmt.executeQuery();
			
			List<Goods> selectGoods = new ArrayList<Goods>();
			Goods goods = null;
			GoodsType goodsType = null;
			while(rs.next()) {
				goods = new Goods();
				goods.setGno(rs.getString(1));
				goods.setGname(rs.getString(2));
				goods.setGoprice(rs.getInt(3));
				goods.setGrprice(rs.getInt(4));
				goods.setGstore(rs.getInt(5));
				goods.setGpicture(rs.getString(6));
				goodsType = new GoodsType();
				goodsType.setTypeid(rs.getInt(7));
				goodsType.setTypename(rs.getString(8));
				goods.setGoodsType(goodsType);
				selectGoods.add(goods);
			}
			rs.close();
			pstmt.close();
			return selectGoods;
	}
	public int GoodsCountingSelectByGnameOrType(String gname,Integer typeid) throws SQLException {
		int countGoods = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if("".equals(gname)){
			gname = null;
		}
		if(gname == null&&typeid == null){
			sql	= "SELECT count(1) AS recordcount FROM " +
					"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
					"ORDER BY goodstype.typeid ASC";
		}else if(gname != null&&typeid == null){
			sql	= "SELECT count(1) AS recordcount FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND gname LIKE '%" + gname + "%' ORDER BY goodstype.typeid ASC";
		}else if(gname == null&&typeid != null){
			sql	= "SELECT count(1) AS recordcount FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND goodstype.typeid = " + typeid + " ORDER BY goodstype.typeid ASC";
		}else{
			sql	= "SELECT count(1) AS recordcount FROM " +
			"goodstype,goodstable WHERE goodstype.typeid=goodstable.typeid " +
			"AND gname LIKE '%" + gname + "%' AND goodstype.typeid = " + typeid + " " +
					"ORDER BY goodstype.typeid ASC";
		}
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			countGoods = rs.getInt("recordcount");
		}
		
		rs.close();
		pstmt.close();
		return countGoods;
	}
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		GoodsPageDAO goodsPageDAO = new GoodsPageDAOImpl(conn);
		try {
			List<Goods> goodsPageSelect = goodsPageDAO.PagingSelectByGnameOrType(1,3,null, null);
			for(Goods goods:goodsPageSelect){
				System.out.println(goods.getGname()+"  "+goods.getGoodsType().getTypename());
			}
			int i = goodsPageDAO.GoodsCountingSelectByGnameOrType(null, null);
			System.out.println(i+"------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
