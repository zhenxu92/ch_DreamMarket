package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.NoticeDAO;
import dao.common.DBUtil;
import dao.entity.Notice;
import dao.impl.DAOFactory;
import service.NoticeService;

class NoticeServiceImpl implements NoticeService {

	public List<Notice> getNotice() {
		List<Notice> allNotice = null;
		Connection connection = DBUtil.getConnection();
		NoticeDAO noticeDAO = DAOFactory.getNoticeDAO(connection);
		try {
			allNotice = noticeDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return allNotice;
	}

	public String add(Notice notice) {
		Connection connection = DBUtil.getConnection();
		NoticeDAO noticeDAO = DAOFactory.getNoticeDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = noticeDAO.insert(notice);
			if (result == 0) {
				message = "添加失败，请稍后再试！";
			}
			
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
		
	}

	public String deleteNoticeByNid(Notice notice) {
		Connection connection = DBUtil.getConnection();
		NoticeDAO noticeDAO = DAOFactory.getNoticeDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = noticeDAO.deleteNoticeByNid(notice);
			if(result==0){
				message = "删除失败，请稍后重试";
			}
		} catch (SQLException e) {
			message="系统繁忙，请稍后重试";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}


