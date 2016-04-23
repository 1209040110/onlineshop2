package com.yichen.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private Map<String,Object> session;
	@Override
	public String execute() throws Exception {
		
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		session.remove("onlineUser");
		return SUCCESS;
	}
	
}
