package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BuserDAO;
import dao.common.DBUtil;
import dao.entity.Buser;
class BuserDAOImpl implements BuserDAO {
	
	private Connection connection;
	
	public BuserDAOImpl(Connection connection) {		
		this.connection = connection;
	}
	public synchronized int insertBuser(Buser buser) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		String SelectGnosql = "SELECT bemail from busertable where bemail=?";
		pstmt = connection.prepareStatement(SelectGnosql);
		pstmt.setString(1, buser.getBemail());
		rs = pstmt.executeQuery();
		if(rs.next()){
			result = 2;
			return result;
		}
		String insertsql = "INSERT INTO busertable(bemail,bpwd) VALUES(?,?)";
		pstmt = connection.prepareStatement(insertsql);
		pstmt.setString(1, buser.getBemail());
		pstmt.setString(2, buser.getBpwd());
		result = pstmt.executeUpdate();

		return result;
	}
	public boolean select(Buser buser) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean exists = false;
		String sql = "SELECT bid,bemail FROM busertable WHERE bemail = ? AND bpwd = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, buser.getBemail());
		pstmt.setString(2, buser.getBpwd());
		
		rs = pstmt.executeQuery();
		exists = rs.next();
		if(exists){
			
			buser.setBid(rs.getInt("bid"));
			buser.setBemail(rs.getString("bemail"));
		}
		
		rs.close();
		pstmt.close();
		return exists;
		
		
	}
	public List<Buser> select() throws SQLException {
		List<Buser> selectBuser = new ArrayList<Buser>();
		Buser buser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM busertable";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			buser = new Buser();
			buser.setBid(rs.getInt(1));
			buser.setBemail(rs.getString(2));
			buser.setBpwd(rs.getString(3));
			selectBuser.add(buser);
		}
		rs.close();
		pstmt.close();
		return selectBuser;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		BuserDAO buserDAO = new BuserDAOImpl(conn);
		Buser buser = new Buser();
		buser.setBemail("YYD199675@163.com");
		buser.setBpwd("77889");
		int i = buserDAO.insertBuser(buser);
		/*List<Buser> allBuser = buserDAO.select();
		for(Buser buser : allBuser){
			System.out.println(buser.getBid()+"  "+buser.getBemail());
		}*/
		System.out.println(i);
		DBUtil.closeConnection(conn);
	}
	public int deleteBuser(Buser buser) throws SQLException {
		int result=0;
		PreparedStatement pstmt = null;

		for(Integer bid : buser.getBidList()){
			String deletesql1 =  "DELETE From userbank WHERE bid=?";
			pstmt = connection.prepareStatement(deletesql1);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			
			String deletesql2 =  "DELETE From busertable WHERE bid=?";
			pstmt = connection.prepareStatement(deletesql2);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
		}
		
			
		
		return result;
	}
	
	
}
