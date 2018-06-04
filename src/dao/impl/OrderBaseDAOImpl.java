package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderBaseDAO;
import dao.common.DBUtil;
import dao.common.GetOrdersnOrCurrentTime;
import dao.entity.Buser;
import dao.entity.OrderBase;
class OrderBaseDAOImpl implements OrderBaseDAO {
	private Connection conn;
	
	public OrderBaseDAOImpl(Connection conn) {		
		this.conn = conn;
	}
	public int insert(String ordersn,Integer bid,Integer count) throws SQLException {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer usermoney = 0;
		String currenttime= GetOrdersnOrCurrentTime.GetCurrentTime();
		String banksql1 = "SELECT money FROM userbank WHERE bid=?";
		pstmt = conn.prepareStatement(banksql1);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			usermoney = rs.getInt(1);
		}
		String sql = "INSERT INTO orderbasetable (ordersn, bid, amount, status, orderdate) " +
				"VALUES (?, ?, ?, ?, str_to_date(?,'%Y-%m-%d'))";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ordersn);
		pstmt.setInt(2, bid);
		pstmt.setInt(3, count);
		if(count-usermoney>0){
			pstmt.setInt(4, 0);
		}else{
			pstmt.setInt(4, 1);
		}
		pstmt.setString(5, currenttime);
		result = pstmt.executeUpdate();
		if(count-usermoney<0){
			int i = usermoney-count;
			String banksql2 = "UPDATE userbank SET	 money=? WHERE bid=?";
			pstmt = conn.prepareStatement(banksql2);
			pstmt.setInt(1, i);
			pstmt.setInt(2, bid);
			result = pstmt.executeUpdate();
			return result;
		}
		
		return 3;
	}
	public List<OrderBase> select() throws SQLException {
		List<OrderBase> allorder = new ArrayList<OrderBase>();
		OrderBase orderBase = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buser buser = null;
		String sql = "SELECT ordersn,busertable.bid,bemail,bpwd,amount,status,orderdate" 
					  + " FROM orderbasetable,busertable WHERE" 
					  + " busertable.bid=orderbasetable.bid";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			orderBase = new OrderBase();
			orderBase.setOrdersn(rs.getString(1));
			buser = new Buser();
			buser.setBid(rs.getInt(2));
			buser.setBemail(rs.getString(3));
			buser.setBpwd(rs.getString(4));
			orderBase.setBuser(buser);
			orderBase.setAmount(rs.getInt(5));
			if(rs.getInt(6)==0){
				orderBase.setStatus("未付款");
			}else{
				orderBase.setStatus("已付款");
			}
			orderBase.setOrderdate(rs.getDate(7));
			allorder.add(orderBase);
		}
		rs.close();
		pstmt.close();
		
		return allorder;
		
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		OrderBaseDAO orderBaseDao = new OrderBaseDAOImpl(conn);
		/*List<OrderBase> allorder = orderBaseDao.select();
		for(OrderBase orderBase : allorder){
			System.out.println(orderBase.getOrdersn()+" "+orderBase.getBuser().getBemail()
					+" "+orderBase.getAmount()+" "+orderBase.getStatus()+" "
					+orderBase.getOrderdate());
		}*/
		
		int i = orderBaseDao.insert("E2017-06-05 15:06:51",19, 800);
		System.out.println(i);
		DBUtil.closeConnection(conn);
	}
	public int deleteOrder(OrderBase orderBase) throws SQLException {
		int result=0;
		PreparedStatement pstmt = null;

		for(String ordersn : orderBase.getOrdersnList()){
			String deletesql1 =  "DELETE From orderdetail WHERE ordersn=?";
			pstmt = conn.prepareStatement(deletesql1);
			pstmt.setString(1, ordersn);
			result = pstmt.executeUpdate();
			
			String deletesql2 =  "DELETE From orderbasetable WHERE ordersn=?";
			pstmt = conn.prepareStatement(deletesql2);
			pstmt.setString(1, ordersn);
			result = pstmt.executeUpdate();
		}
		
			
		
		return result;
	}
	
}


