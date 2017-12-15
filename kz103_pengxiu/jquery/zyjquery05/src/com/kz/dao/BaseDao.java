package com.kz.dao;

import java.util.List;

import com.kz.entity.Auction;
import com.kzxy.utils.Returns;
import com.kzxy.utils.Sql;

public class BaseDao {
	//通用的查询
	public static List list(Object obj){
		String sql = new Sql().selectSql(obj, 1,0,0);
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	public static void main(String[] args) {
		List list = list(new Auction());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
