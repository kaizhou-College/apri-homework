package com.kz.examination.dao;

import java.util.List;

import com.kz.examination.entity.QueryView;
import com.kz.examination.entity.TBL_FWXX;
import com.kz.examination.entity.Tbl_User;
import com.kz.examination.utils.Returns;
import com.kz.examination.utils.Sql;
import com.kz.examination.wed.action.Tbl_fwxxAction;

public class BaseDao {
	
	//通用的修改
	public static int update(Object obj){
		int num=-1;
		String uidSql = new Sql().UIDSql(obj, 1, null);
		num=new Returns().returnUID(obj, uidSql, true);
		return num;
	}
	//通用添加
	public static int add(Object obj,String sqlNextval){
		int num=-1;
		String sql=null;
		sql=new Sql().UIDSql(obj, 2, sqlNextval);
		num = new Returns().returnUID(obj, sql, true);
		return num;
	}
	
	//通用的普通查询
	public static List Select(Object obj) {
		String sql = new Sql().selectSql(obj, 1, 0,0);
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	//查询最大页数
	public static int pageYS(Object obj, int pagesize) {
		String sql = new Sql().selectSql(obj, 4,0, pagesize);
		int size = new Returns().returnUID(obj, sql, false);
		int pagemax=(size-1)/pagesize+1;
		return pagemax;
	}
	//分页查询
	public static List selectFY(Object obj, int pageindex,
			int pagesize) {
		String sql = new Sql().selectSql(obj, 3, pageindex, pagesize);
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	//测试
	public static void main(String[] args) {
		Tbl_User user=new Tbl_User();
		user.setUpass("123");
		user.setUname("user");
//		System.out.println(add(user, "UUId"));
		
//		System.out.println(pageYS(new TBL_FWXX(),5));
//		System.out.println(selectFY(new  TBL_FWXX(),1,2));
		TBL_FWXX tblFWXX = new TBL_FWXX();
		tblFWXX.setFwid(11);
		System.out.println(listID(tblFWXX));
	}
	//通用根据id查询
	public static List listID(Object obj) {
		String sql = new Sql().selectSql(obj, 2, 0,0);
		List list = new Returns().returnList(obj, sql);
		return list;
	}
	public static int deteleTbl(Object  obj) {
		String sql = new Sql().UIDSql(obj, 3,null);
		int returnUID=-1;
		returnUID= new Returns().returnUID(obj, sql, true);
		return returnUID;
	}
	public static int  insert(Object obj) {
		int num=-1;
		String sql = new Sql().UIDSql(obj, 2, "fwxx");
		num = new Returns().returnUID(obj, sql, true);
		return num;
	}
	public static int  insert(Object obj,String sqlnext) {
		int num=-1;
		String sql = new Sql().UIDSql(obj, 2, sqlnext);
		num = new Returns().returnUID(obj, sql, true);
		return num;
	}
	
}
