package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.UserDao;
import com.yichen.entity.User;

public class CheckUnameAction extends ActionSupport {
	private String uname;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void checkUname() throws IOException{
		UserDao userDao=new UserDao();
		User user=userDao.selectById(uname);
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer = response.getWriter();  
		if(user!=null){
			writer.write("hasRes");
			
		}else{
			writer.write("ok");
		}
		writer.flush();
		writer.close();
		
	}

}
