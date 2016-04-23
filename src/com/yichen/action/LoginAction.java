package com.yichen.action;




import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.UserDao;
import com.yichen.entity.User;


public class LoginAction extends ActionSupport {
	private String username;//用户名
	private String pwd;
	private User  user;
	private Map<String,Object> session;
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		user=userDao.checkLogin(username,pwd);
		if(user!=null){
			System.out.println("login success---------");
			ActionContext actionContext=ActionContext.getContext();
			session=actionContext.getSession();
			session.put("onlineUser",user);
			
		}else
			return LOGIN;
		return SUCCESS;
	}

}
