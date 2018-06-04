package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.FocusService;

import dao.FocusDAO;
import dao.common.DBUtil;
import dao.entity.Focus;
import dao.impl.DAOFactory;

class FocusServiceImpl implements service.FocusService {

	public List<Focus> getFocusGood(String bemail) {
		List<Focus> selectFocusGoods = null;
		Connection connection = DBUtil.getConnection();
		FocusDAO focusDAO = DAOFactory.getFocusDAO(connection);
		try {
			selectFocusGoods = focusDAO.selectFocusGood(bemail);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectFocusGoods;
	}
	public static void main(String[] args) {
		FocusService focusService = new FocusServiceImpl();
		List<Focus> getFocusGoods = new ArrayList<Focus>();
		getFocusGoods = focusService.getFocusGood("Mao@163.com");
		for(Focus focus:getFocusGoods){
			System.out.println(focus.getFid()+" "+focus.getFocustime());
		}
	}
	public String add(Integer bid, String gno) {
		Connection connection = DBUtil.getConnection();
		FocusDAO focusDAO = DAOFactory.getFocusDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = focusDAO.addFocusGood(bid, gno);
			if (result == 0) {
				message = "添加失败，请稍后再试！";
			}
			
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
	}
	
}


