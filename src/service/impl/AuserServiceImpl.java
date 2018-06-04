package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AuserDAO;
import dao.common.DBUtil;
import dao.entity.Auser;
import dao.impl.DAOFactory;
import service.AuserService;

public class AuserServiceImpl implements AuserService {

	public String login(Auser auser) {
		
		Connection connection = DBUtil.getConnection()	;
		AuserDAO auserDAO = DAOFactory.getAuserDAO(connection);
		
		String message = null;
		
		try {
			boolean success = auserDAO.select(auser);
			if(!success){
				message= "Incorrect info, please retry";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		
		return message;
	}

}
