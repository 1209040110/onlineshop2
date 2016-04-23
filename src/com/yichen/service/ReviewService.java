package com.yichen.service;

import com.yichen.dao.ProductDao;
import com.yichen.dao.ReviewDao;
import com.yichen.entity.Product;
import com.yichen.entity.Review;

public class ReviewService {
	
	//新增商品一条评价 业务逻辑
	public boolean addANewReview(String uid,String pid,String content,float score)
	{
		ReviewDao rDao=new ReviewDao();
		boolean f1=rDao.addReview(uid, pid, content, score);
		if(!f1)
			return false;
		ProductDao pDao=new ProductDao();
		Product p=pDao.selectByPId(pid);
		if(p==null)
			return false;
		float sco=(p.getScore()*p.getEvaluationsum()+score)/(p.getEvaluationsum()+1);
		p.setEvaluationsum(p.getEvaluationsum()+1);
		p.setScore(sco);
		boolean f2=pDao.updatePro(p);
		return f2;
	}

}
