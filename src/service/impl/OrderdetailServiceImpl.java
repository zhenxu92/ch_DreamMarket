package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OrderdetailDAO;
import dao.common.DBUtil;
import dao.entity.OrderDetail;
import dao.impl.DAOFactory;
import service.OrderdetailService;

class OrderdetailServiceImpl implements OrderdetailService{

	public String add(String ordersn,String []gnoList,Integer []shoppingnumList) {
		Connection connection = DBUtil.getConnection();
		OrderdetailDAO orderdetailDAO = DAOFactory.getOrderdetailDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = orderdetailDAO.insert(ordersn,gnoList, shoppingnumList);
			if (result == 0) {
				message = "下单失败，稍后再试";
			}
			
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
	}

	public List<OrderDetail> selectOrderdetails(Integer bid) {
		List<OrderDetail> selectDetails = null;
		Connection connection = DBUtil.getConnection();
		OrderdetailDAO orderdetailDAO = DAOFactory.getOrderdetailDAO(connection);
		try {
			selectDetails = orderdetailDAO.select(bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectDetails;
	}
	
}
