package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AuserDAO;
import dao.common.DBUtil;
import dao.entity.Auser;

class AuserDAOImpl implements AuserDAO {
	private Connection conn;
	
	public AuserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean select(Auser auser) throws SQLException {
		boolean exists = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT 1 FROM ausertable WHERE aname = ? AND apwd = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, auser.getAname());
		pstmt.setString(2, auser.getApwd());
		
		rs = pstmt.executeQuery();
		exists = rs.next();
		rs.close();
		pstmt.close();
		return exists;
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtil.getConnection();
		AuserDAO auserDAO = new AuserDAOImpl(connection);
		Auser auser = new Auser()	;
		auser.setAname("admin");
		auser.setApwd("admin");
		boolean exists = auserDAO.select(auser);
		System.out.println("exists:"+exists);
		DBUtil.closeConnection(connection);
	}

}
