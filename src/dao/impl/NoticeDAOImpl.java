package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NoticeDAO;
import dao.common.DBUtil;
import dao.common.GetOrdersnOrCurrentTime;
import dao.entity.Notice;

class NoticeDAOImpl implements NoticeDAO {
	private Connection connection;
	
	public NoticeDAOImpl(Connection connection) {		
		this.connection = connection;
	}
	public int deleteNoticeByNid(Notice notice) throws SQLException {
		int result=0;
		PreparedStatement pstmt = null;
		for(Integer nid:notice.getNidList()){
			String deleteCartGoodssql =  "DELETE From noticetable WHERE nid=?";
			pstmt = connection.prepareStatement(deleteCartGoodssql);
			pstmt.setInt(1, nid);
			result = pstmt.executeUpdate();
		}
		return result;
	}
	public synchronized int insert(Notice notice) throws SQLException {
		int result = -1;
		String currenttime =  GetOrdersnOrCurrentTime.GetCurrentTime();   
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO noticetable(ntitle,ncontent,ntime) VALUES (?,?,str_to_date(?,'%Y-%m-%d'))";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, notice.getNtitle());
		pstmt.setString(2, notice.getNcontent());
		pstmt.setString(3,currenttime);
		result = pstmt.executeUpdate();
		return result;
	}
	
	
	public List<Notice> select() throws SQLException {
		List<Notice> selectNotice = new ArrayList<Notice>();
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM noticetable";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			notice = new Notice();
			notice.setNid(rs.getInt(1));
			notice.setNtitle(rs.getString(2));
			notice.setNcontent(rs.getString(3));
			notice.setNtime(rs.getString(4));
			selectNotice.add(notice);
		}
		rs.close();
		pstmt.close();
		return selectNotice;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		NoticeDAO noticeDAO = new NoticeDAOImpl(conn);
		Notice notice = new Notice();
		notice.setNtitle("过季促销3折起");
		notice.setNcontent("明日起将进行过季商品促销活动，全场3折大放血，赶紧来抢购吧！！！");
		int i = noticeDAO.insert(notice);
		/*List<Notice> allNotice = noticeDAO.select();
		for(Notice notice : allNotice){
			System.out.println(notice.getNid()+"  "+notice.getNtitle()+" "+notice.getNcontent()
					+" "+notice.getNtime());
		}*/
		System.out.println(i);
		DBUtil.closeConnection(conn);
	}

	
	
}
