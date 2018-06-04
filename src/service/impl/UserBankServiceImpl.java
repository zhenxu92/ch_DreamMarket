package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserBankDAO;
import dao.common.DBUtil;
import dao.entity.UserBank;
import dao.impl.DAOFactory;
import service.UserBankService;

class UserBankServiceImpl implements UserBankService{

	public String login(UserBank userBank) {
		Connection connection = DBUtil.getConnection();
		UserBankDAO userBankDAO = DAOFactory.getUserBankDAO(connection);
		String message = null;
		try {
			boolean success = userBankDAO.select(userBank);
			if(!success){
				message="incorrect info";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
