package web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import service.NoticeService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.entity.Notice;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice>,ServletResponseAware{
	/****/
	private static final long serialVersionUID = 7241901984805595906L;
	private Notice notice = new Notice();
	private HttpServletResponse response;
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Notice getModel() {
		return notice;
	}
	public String add(){
		NoticeService noticeService = ServiceFactory.getNoticeService();
		String message = noticeService.add(notice);
		if(message == null){
			return "addSuccess";
		}
		this.addActionError(message);
		return INPUT;
	}
	public String delete() throws IOException{
		NoticeService noticeService = ServiceFactory.getNoticeService();
		String message = noticeService.deleteNoticeByNid(notice);
		if(message == null){
			return "deleteSuccess";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<script>alert('"+message+"');</script>");
		response.getWriter().flush();
		return INPUT;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}
}
