package web;

import service.AuserService;
import service.impl.ServiceFactory;

import com.opensymphony.xwork2.Action;

import dao.entity.Auser;

public class AuserAction extends BaseAction<Auser>{

	private static final long serialVersionUID = 739336623844245345L;
	public String login(){
		AuserService auserService = ServiceFactory.getAuserService();
		String message = auserService.login(model);
		if(message == null){
			session.setAttribute("aname",model.getAname());
			return "loginsuccess";
		}else{
			this.addActionError(message);
			return Action.INPUT;
		}
	}

}
