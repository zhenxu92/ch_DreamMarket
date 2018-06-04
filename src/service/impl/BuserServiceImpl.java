package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BuserDAO;
import dao.common.DBUtil;
import dao.entity.Buser;
import dao.impl.DAOFactory;
import service.BuserService;

class BuserServiceImpl implements BuserService {

	public List<Buser> getBusers() {
		List<Buser> allBuser = null;
		Connection connection = DBUtil.getConnection();
		BuserDAO buserDAO = DAOFactory.getBuserDAO(connection);
		try {
			allBuser = buserDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return allBuser;
	}
	public String addBuser(Buser buser) {
		String message = null;
		Connection connection = DBUtil.getConnection();
		BuserDAO buserDAO = DAOFactory.getBuserDAO(connection);
		try {
			int result = buserDAO.insertBuser(buser);
			if(result == 2){
				message = "Existing username, please re-enter";
			}else if(result == 0){
				message = "Failed registration, please retry";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return message;
	}
	public String login(Buser buser) {
		
		Connection connection = DBUtil.getConnection();
		BuserDAO buserDAO = DAOFactory.getBuserDAO(connection);
		String message = null;
		try {
			boolean success = buserDAO.select(buser);
			if(!success){
				message= "Incorrect info, try again.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		
		return message;
	}

	public String deleteBuser(Buser buser) {
		Connection connection = DBUtil.getConnection();
		BuserDAO buserDAO = DAOFactory.getBuserDAO(connection);
		String message = null;
		
		try {
			int result = buserDAO.deleteBuser(buser);
			if(result == 0){
				message="Failed to delete user.";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return message;
		
	}

	

}
