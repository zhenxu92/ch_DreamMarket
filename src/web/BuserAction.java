package web;

import java.io.IOException;

import dao.entity.Buser;

public class BuserAction extends BaseAction<Buser>{
	/****/
	private static final long serialVersionUID = -3182242674887543108L;
	public String login() throws IOException{
		String message = buserService.login(model);
		if(message == null){
			session.removeAttribute("buser");
			session.setAttribute("buser",model);
			cartService.addInCart(null, model.getBid(), null,model.getIp());
			return "loginsuccess";
		}else{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('"+message+"');</script>");
			response.getWriter().flush();
			return INPUT;
		}
	}
	public String register() throws IOException{
		String message = buserService.addBuser(model);
		if(message == null){
			return SUCCESS;
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<script>alert('"+message+"');</script>");
		response.getWriter().flush();
		return INPUT;
	}
	public String delete() throws IOException{
		if(model.getBidList() == null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert('Select the user you want to delete');</script>");
			response.getWriter().flush();
			return INPUT;
		}
		String message2 = buserService.deleteBuser(model);
		if (message2 == null) {
			return "deleteBuserSuccess";
		}
		return INPUT;
	
		
	}
	public String logout(){
		session.invalidate();
		return SUCCESS;
	}

}
