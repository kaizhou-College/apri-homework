package com.kzxy.dao;

import java.util.List;

import com.kzxy.entity.TBL_QX;
import com.kzxy.utils.Returns;
import com.kzxy.utils.Sql;

public class BaseDao {
	//ͨ�ò�ѯ����
	public  List  list(Object obj){
		//new Sql()������ǰд��һ��һЩ����������ͨ�÷��� 
		String sql = new Sql().selectSql(obj, 1,0,0);
		//new ReturnsҲ������ǰд��һ������ ��������˻����ķ���list��int
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
