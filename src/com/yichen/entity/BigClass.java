package com.yichen.entity;

import java.util.HashSet;
import java.util.Set;

public class BigClass {
	private String bc_id;//大类id
	private String bc_name;//大类名称
	private Set<SmallClass> smallClasses=new HashSet<SmallClass>();
	
	public Set<SmallClass> getSmallClasses() {
		return smallClasses;
	}
	public void setSmallClasses(Set<SmallClass> smallClasses) {
		this.smallClasses = smallClasses;
	}
	public String getBc_id() {
		return bc_id;
	}
	public void setBc_id(String bc_id) {
		this.bc_id = bc_id;
	}
	public String getBc_name() {
		return bc_name;
	}
	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bc_id == null) ? 0 : bc_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BigClass other = (BigClass) obj;
		if (bc_id == null) {
			if (other.bc_id != null)
				return false;
		} else if (!bc_id.equals(other.bc_id))
			return false;
		return true;
	}
	

}
