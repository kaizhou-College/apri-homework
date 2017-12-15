package com.kzxy.dao;

import java.util.List;

import com.kzxy.utils.Returns;

public class QxDao {
	public List qxList(Object obj,int id){
		String sql="select * from TBL_QX where sfid="+id;
		List list = new Returns().returnList(obj, sql);
		return list;
	}
}
