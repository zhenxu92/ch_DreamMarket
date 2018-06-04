package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderdetailDAO;
import dao.common.DBUtil;
import dao.entity.Goods;
import dao.entity.OrderBase;
import dao.entity.OrderDetail;

class OrderdetailDAOImpl implements OrderdetailDAO {
	private Connection conn;
	
	public OrderdetailDAOImpl(Connection conn) {		
		this.conn = conn;
	}

	public int insert(String ordersn, String []gnoList, Integer []shoppingnumList)throws SQLException {
		int result = -1;
		int i = 0;
		for(String gno:gnoList){
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO orderdetail(ordersn,gno,shoppingnum) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ordersn);
			pstmt.setString(2, gno);
			pstmt.setInt(3, shoppingnumList[i]);
			result = pstmt.executeUpdate();
			i++;
		}
		return result;
	}

	public List<OrderDetail> select(Integer bid) throws SQLException {
		List<OrderDetail> selectOrderDetail = new ArrayList<OrderDetail>();
		OrderDetail orderDetail = null;
		Goods goods = null;
		OrderBase orderBase = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT orderbasetable.ordersn,amount,status,orderdate,goodstable.gno,gname,gpicture,goprice,shoppingnum FROM orderdetail,orderbasetable,goodstable WHERE orderdetail.ordersn=orderbasetable.ordersn AND orderdetail.gno=goodstable.gno AND bid=? ORDER BY orderbasetable.ordersn";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		while(rs.next()){
			orderDetail = new OrderDetail();
			orderBase = new OrderBase();
			orderBase.setOrdersn(rs.getString(1));
			orderBase.setAmount(rs.getInt(2));
			if(rs.getInt(3) == 0){
				orderBase.setStatus("未付款");
			}else{
				orderBase.setStatus("已付款");
			}
			orderBase.setOrderdate(rs.getDate(4));
			orderDetail.setOrderBase(orderBase);
			goods = new Goods();
			goods.setGno(rs.getString(5));
			goods.setGname(rs.getString(6));
			goods.setGpicture(rs.getString(7));
			goods.setGoprice(rs.getInt(8));
			orderDetail.setGoods(goods);
			orderDetail.setShoppingnum(rs.getInt(9));
			selectOrderDetail.add(orderDetail);
		}
		rs.close();
		pstmt.close();
		
		return selectOrderDetail;
		
	}
	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtil.getConnection();
		OrderdetailDAO orderdetailDAO = new OrderdetailDAOImpl(connection);
		
		List<OrderDetail> selectOrderDetail = new ArrayList<OrderDetail>();
		selectOrderDetail = orderdetailDAO.select(19);
		
		for(OrderDetail orderDetail:selectOrderDetail){
			System.out.println(orderDetail.getOrderBase().getOrdersn());
		}
		
	}

}
