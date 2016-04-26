package com.yichen.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.yichen.entity.SmallClass;

public class SmallClassDao {
	
	//传进来的是用户小类id的list
	public Set<SmallClass> selectScsByScs(Session session,Set<String> scids){
		Set<SmallClass>  scset=new HashSet<SmallClass>();
		for(String scid:scids){
			SmallClass sc=(SmallClass) session.get(SmallClass.class,scid);
			scset.add(sc);
		}
		return scset;
	}
	
	
	
}
