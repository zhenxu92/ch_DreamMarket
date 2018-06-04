package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserBankDAO;
import dao.entity.UserBank;

class UserBankDAOImpl implements UserBankDAO{
	private Connection connection;
	public UserBankDAOImpl(Connection connection) {		
		this.connection = connection;
	}
	public boolean select(UserBank userBank) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean exists = false;
		String sql = "SELECT account,accountpassword FROM userbank WHERE account = ? AND accountpassword = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, userBank.getAccount());
		pstmt.setString(2, userBank.getAccountpassword());
		rs = pstmt.executeQuery();
		exists = rs.next();
		System.out.println(rs.next());
		rs.close();
		pstmt.close();
		return exists;
	}
	
	
}
