package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.Notice;

public interface NoticeDAO {
	List<Notice> select() throws SQLException;
	int insert(Notice notice) throws SQLException;
	int deleteNoticeByNid(Notice notice) throws SQLException;
	
}
