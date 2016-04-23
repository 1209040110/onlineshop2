package com.yichen.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.FavouriteDao;
import com.yichen.entity.User;
import com.yichen.service.FavoriteService;
import com.yichen.util.ConstVar;

public class AddFav  extends ActionSupport{
	private String pid;
	private Map<String,Object> session;
	
	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public void addf() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer = response.getWriter();  
		if(user!=null){
			FavoriteService fs=new FavoriteService();
			boolean f=fs.addAFavorite(user.getU_id(), pid);
			if(f)
				writer.write(ConstVar.OK_STRING);
			else
				writer.write(ConstVar.FAILED_STRING);
		}else{
			writer.write(ConstVar.NOT_LOGIN_STRING);
		}
		writer.flush();
		writer.close();
	}

}
