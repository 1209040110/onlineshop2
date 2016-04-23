package com.yichen.action;



import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.UserDao;
import com.yichen.entity.User;

public class RegisterAction extends ActionSupport {
	private User u;
	
	

	public User getU() {
		return u;
	}



	public void setU(User u) {
		this.u = u;
	}



	@Override
	public String execute() throws Exception {
		UserDao userDao=new UserDao();
		userDao.addANewUser(u);
		return SUCCESS;
	}

	
 
}
