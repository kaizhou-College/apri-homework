package com.kzxy.dao;

import java.util.List;

import com.kzxy.entity.TBL_QX;
import com.kzxy.utils.Returns;
import com.kzxy.utils.Sql;

public class BaseDao {
	//通用查询所有
	public  List  list(Object obj){
		//new Sql()是我以前写的一个一些经常遇到的通用方法 
		String sql = new Sql().selectSql(obj, 1,0,0);
		//new Returns也是我以前写的一个方法 里面包括了基本的返回list与int
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	public List  listId(Object obj){
		String sql = new Sql().selectSql(obj, 2,0,0);
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new BaseDao().listId(new TBL_QX(1,null)));
	}
}
