package com.yichen.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ReviewDao;
import com.yichen.entity.Review;
import com.yichen.entity.User;
import com.yichen.service.ReviewService;
import com.yichen.util.ConstVar;

public class AddReviewAction extends ActionSupport {
	private Review  r;
	private Map<String,Object> session;
	

	public Review getR() {
		return r;
	}

	public void setR(Review r) {
		this.r = r;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public void addre() throws Exception {
		ReviewDao reviewDao=new ReviewDao();
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer = response.getWriter();
        r.setR_content(URLDecoder.decode(r.getR_content(),"UTF-8"));
        System.out.println(r.getR_content());
		if(user==null){
			writer.write(ConstVar.NOT_LOGIN_STRING);
		}
		r.setUid(user.getU_id());
		ReviewService rs=new ReviewService();
		boolean f=rs.addANewReview(r.getUid(),r.getP_id(),r.getR_content(),r.getScore());
		if(!f){
			writer.write(ConstVar.FAILED_STRING);
		}else{
			writer.write(ConstVar.OK_STRING);
		}
		writer.flush();
		writer.close();
	}
	
}
