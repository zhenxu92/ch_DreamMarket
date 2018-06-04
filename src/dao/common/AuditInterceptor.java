package dao.common;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import dao.entity.Buser;

@SuppressWarnings("serial")
public class AuditInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext  actioncontext  = ActionContext.getContext();
		Map<String,Object> session = actioncontext.getSession();
		Buser buser = (Buser)session.get("buser");
		if(buser!=null&&0!=buser.getBid()){
			String result = invocation.invoke();
			return result;
		}
		return "nologin";
	}
}
