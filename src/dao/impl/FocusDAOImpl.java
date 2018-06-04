package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FocusDAO;
import dao.common.DBUtil;
import dao.common.GetOrdersnOrCurrentTime;
import dao.entity.Buser;
import dao.entity.Focus;
import dao.entity.Goods;

class FocusDAOImpl implements FocusDAO {
	private Connection connection;
	
	public FocusDAOImpl(Connection connection) {		
		this.connection = connection;
	}
	public int addFocusGood(Integer bid,String gno) throws SQLException {
		int result = -1;
		String currenttime =  GetOrdersnOrCurrentTime.GetCurrentTime();     
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO focustable(bid,gno,focustime) VALUES(?,?,str_to_date(?,'%Y-%m-%d'))";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bid);
		pstmt.setString(2, gno);
		pstmt.setString(3, currenttime);
		result = pstmt.executeUpdate();
		return result;
	}
	public List<Focus> selectFocusGood(String bemail) throws SQLException {
		List<Focus> selectFocusGood = new ArrayList<Focus>();
		Focus focus = null;
		Goods focusgoods = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT fid,goodstable.gno,gname,goprice,grprice,gpicture,focustime FROM busertable,goodstable,focustable" 
					+" WHERE focustable.gno=goodstable.gno AND focustable.bid=busertable.bid AND busertable.bemail='"+ bemail +"'";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			focus = new Focus();
			focus.setFid(rs.getInt(1));
			focusgoods = new Goods();
			focusgoods.setGno(rs.getString(2));
			focusgoods.setGname(rs.getString(3));
			focusgoods.setGoprice(rs.getInt(4));
			focusgoods.setGrprice(rs.getInt(5));
			focusgoods.setGpicture(rs.getString(6));
			focus.setGoods(focusgoods);
			
			focus.setFocustime(rs.getDate(7).toString());
			selectFocusGood.add(focus);
		}
		rs.close();
		pstmt.close();
		return selectFocusGood;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		FocusDAO focusDAO = new FocusDAOImpl(conn);
		Buser buser = new Buser();
		buser.setBemail("Mao@163.com");
		buser.setBid(19);
		List<Focus> selectFocusGood = new ArrayList<Focus>();
		selectFocusGood=focusDAO.selectFocusGood(buser.getBemail());
		for(Focus focus : selectFocusGood){
			System.out.println(focus.getFid()+"  "+focus.getGoods().getGno()+" "+focus.getFocustime());
		}
		System.out.println(focusDAO.addFocusGood(19, "05880102"));
	}
	
}
