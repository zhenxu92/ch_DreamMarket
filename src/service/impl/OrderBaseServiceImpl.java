package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.OrderBaseService;

import dao.OrderBaseDAO;
import dao.common.DBUtil;
import dao.entity.OrderBase;
import dao.impl.DAOFactory;

class OrderBaseServiceImpl implements OrderBaseService {

	public List<OrderBase> getAllOrder() {
		List<OrderBase> allOrder = null;
		Connection connection = DBUtil.getConnection();
		OrderBaseDAO orderBaseDAO = DAOFactory.getOrderBaseDAO(connection);
		
		try {
			allOrder = orderBaseDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return allOrder;
		
	}

	public String add(String ordersn,Integer bid,Integer count) {
		Connection connection = DBUtil.getConnection();
		OrderBaseDAO orderBaseDAO = DAOFactory.getOrderBaseDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = orderBaseDAO.insert(ordersn,bid, count);
			if (result == 0) {
				message = "下单失败，稍后再试";
			}else if(result == 3){
				message = "用户余额不足！请完成付款";
			}
			
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
	}

	public String deleteOrderBase(OrderBase orderBase) {
		Connection connection = DBUtil.getConnection();
		OrderBaseDAO orderBaseDAO = DAOFactory.getOrderBaseDAO(connection);
		String message = null;
		
		try {
			int result = orderBaseDAO.deleteOrder(orderBase);
			if(result == 0){
				message="订单删除失败";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return message;
		
	}

	
}
