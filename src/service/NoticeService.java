package service;

import java.util.List;

import dao.entity.Notice;
public interface NoticeService {
	List<Notice> getNotice();
	String add(Notice notice);
	String deleteNoticeByNid(Notice notice);
}
