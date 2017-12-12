package com.wtg.Action;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.House;

public class shanchuAction {
	private int sid;
	public String shanchu(){
		System.out.println("sid==="+sid);
		House house=new House();
		int delete = BaseDao.delete(house, sid);
		if (delete>0) {
			return "success";
		}
		return "loser";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
