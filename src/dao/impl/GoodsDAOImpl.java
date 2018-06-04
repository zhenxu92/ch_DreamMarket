package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDAO;
import dao.common.DBUtil;
import dao.entity.Goods;
import dao.entity.GoodsType;


class GoodsDAOImpl implements GoodsDAO{
	private Connection conn;
	
	public GoodsDAOImpl(Connection conn) {		
		this.conn = conn;
	}
	public Goods selectGoodsDetails(String gno) throws SQLException {
		Goods goods = new Goods();
		GoodsType goodsType = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT gno,gname,goprice,grprice,gstore,gpicture,goodstype.typeid,goodstype.typename FROM goodstype, goodstable WHERE goodstype.typeid=goodstable.typeid AND trim(gno)=?";
		ResultSet rs = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gno.trim());
		rs = pstmt.executeQuery();
		if (rs.next()){
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
		}
		return goods;
	}
	public int deleteGoods(Goods goods) throws SQLException {
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rs;
		for(String gno : goods.getGnoList()){
			String selectCartGoodssql="select 1 from carttable where gno=?";
			pstmt = conn.prepareStatement(selectCartGoodssql);
			pstmt.setString(1, gno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return 2;
			}
			String selectOrderdetail="select 1 from orderdetail where gno=?";
			pstmt = conn.prepareStatement(selectOrderdetail);
			pstmt.setString(1, gno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return 3;
			}
			
			
			String deletesql =  "DELETE From goodstable WHERE gno=?";
			pstmt = conn.prepareStatement(deletesql);
			pstmt.setString(1, gno);
			result = pstmt.executeUpdate();
		}
		return result;
	}
	public List<Goods> selectChoisedGoods(Goods goods) throws SQLException {
		List<Goods> selectChoiseGoods = new ArrayList<Goods>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsType goodsType = null;
		for(String gno:goods.getGnoList()){
			System.out.println();
			String sql = "SELECT goodstable.gno,goodstable.gname,goodstable.goprice,goodstable.grprice,goodstable.gstore,goodstable.gpicture,goodstype.typeid,goodstype.typename FROM goodstype,goodstable Where goodstype.typeid=goodstable.typeid AND trim(goodstable.gno)="+gno+" ORDER BY goodstype.typeid ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
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
				selectChoiseGoods.add(goods);
			}
		}
		return selectChoiseGoods;
	}
	
	public synchronized int insert(Goods goods) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String SelectGnosql = "SELECT gno from goodstable where trim(gno)=?";
		pstmt = conn.prepareStatement(SelectGnosql);
		pstmt.setString(1, goods.getGno());
		rs = pstmt.executeQuery();
		if(rs.next()){
			result = 2;
			return result;
		}
		if(goods.getGoprice()<goods.getGrprice()){
			result = 3;
			return result;
		}
		
		
		String sql = "INSERT INTO goodstable (gno, gname, goprice, grprice, gstore, gpicture, typeid) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goods.getGno());
		pstmt.setString(2, goods.getGname());
		pstmt.setInt(3, goods.getGoprice());
		pstmt.setDouble(4, goods.getGrprice());
		pstmt.setInt(5, goods.getGstore());
		pstmt.setString(6, goods.getGpicture());
		pstmt.setInt(7, goods.getGoodsType().getTypeid());
		result = pstmt.executeUpdate();
		
		return result;
	}
	
	public List<Goods> select() throws SQLException {
		List<Goods> selectGoods = new ArrayList<Goods>();
		Goods goods = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsType goodsType = null;
		String sql = "SELECT goodstable.gno,goodstable.gname,goodstable.goprice,goodstable.grprice,goodstable.gstore,goodstable.gpicture,goodstype.typeid,goodstype.typename FROM goodstype,goodstable where goodstype.typeid=goodstable.typeid ORDER BY goodstype.typeid ASC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
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
	
	
	public List<Goods> select2(String gname,Integer typeid) throws SQLException {
		List<Goods> selectGoods = new ArrayList<Goods>();
		Goods goods = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsType goodsType = null;
		String sql = null;
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
			"AND gname LIKE '%" + gname + "%' AND goodstype.typeid = " + typeid + "" +
					"ORDER BY goodstype.typeid ASC";
		}
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
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
	public int update(Goods goods) throws SQLException {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "UPDATE goodstable SET	gname=?,goprice=?,grprice=?,gstore=?," 
			+         "typeid=? WHERE trim(gno)=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goods.getGname());
		pstmt.setInt(2, goods.getGoprice());
		pstmt.setDouble(3, goods.getGrprice());
		pstmt.setInt(4, goods.getGstore());
		pstmt.setInt(5, goods.getGoodsType().getTypeid());
		pstmt.setString(6, goods.getGno());
		result = pstmt.executeUpdate();
		return result;
	}
	
	public boolean selectGno(String gno) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean exists = false;
		String sql = "SELECT 1 FROM goodstable WHERE trim(gno) = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gno);
		rs = pstmt.executeQuery();
		exists = rs.next();
		return exists;
	}
	public static void main(String[] args)  throws SQLException {
		Connection conn = DBUtil.getConnection();
		GoodsDAO goodsDAO = new GoodsDAOImpl(conn);
		Goods goods = new Goods();
		/*String gnoList[]={"1404507100","05880102"};
		goods.setGnoList(gnoList);
		List<Goods> selectChoisedGoods = new ArrayList<Goods>();
		selectChoisedGoods = goodsDAO.selectChoisedGoods(goods);
		for(Goods goods1:selectChoisedGoods){
			System.out.println(goods1.getGname());
		}*/
		goods.setGno("1404507100");
		System.out.println(goodsDAO.updateGstore("125874630", 2));
		DBUtil.closeConnection(conn);
	}
	public int updateGstore(String gno,Integer shoppingnum) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE goodstable SET	gstore=gstore-? WHERE trim(gno)=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, shoppingnum);
		pstmt.setString(2, gno.trim());
		result = pstmt.executeUpdate();
		return result;
	}
	
	
	
	
	
	
	
	

}
