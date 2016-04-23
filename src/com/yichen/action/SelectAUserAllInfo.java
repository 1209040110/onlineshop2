package com.yichen.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.entity.User;

public class SelectAUserAllInfo extends ActionSupport {
	private User u;
	private Map<String,Object> session;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		u=(User)session.get("onlineUser");
		if(u!=null)
			return SUCCESS;
		else
			return LOGIN;
	}

}
