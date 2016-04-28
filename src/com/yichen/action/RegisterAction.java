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
		boolean f=userDao.addANewUser(u);
		if(!f){
			this.addActionError("注册失败！");
			return ERROR; 
		}
		return SUCCESS;
	}

	
 
}
