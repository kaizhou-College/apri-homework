package com.kzxy.wed.action;

import java.util.List;

import com.kzxy.utils.Returns;

public class JdDao{

	public List jdList(Object obj,int id) {
		String sql="select * from TBL_JD where QXID="+id;
		List list = new Returns().returnList(obj, sql);
		return list;
	}

}
