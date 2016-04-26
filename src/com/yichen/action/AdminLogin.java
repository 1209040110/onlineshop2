package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.entity.User;
import com.yichen.util.ConstVar;

public class AdminLogin extends ActionSupport {
	private String uname;
	private String pwd;
	private Map<String,Object> session;
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void check(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		PrintWriter w=null;
        try {
			w = response.getWriter();
			if(uname!=null&&pwd!=null&&uname.equals("admin")&&pwd.equals("admin")){
				ActionContext actionContext=ActionContext.getContext();
				session=actionContext.getSession();
				session.put("onlineAdmin","admin");
				w.write(ConstVar.OK_STRING);
			}else
				w.write(ConstVar.FAILED_STRING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(w!=null){
				w.flush();
				w.close();
			}
		}
        
		
	}
}
