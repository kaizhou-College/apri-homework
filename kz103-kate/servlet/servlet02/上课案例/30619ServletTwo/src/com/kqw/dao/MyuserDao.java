package com.kqw.dao;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import entity.Myuser;
//oracle优化----最基础：
public class MyuserDao {
	//java调用存储函数
	public void testFun(int year){
		Connection conn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareCall("{?=call kz103.loveYou(?)}");
			//给占位符赋值
			//返回值：out
			st.registerOutParameter(1,OracleTypes.VARCHAR);
			//参数：in
			st.setInt(2, year);
			st.execute();
			String re = st.getString(1);
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
	}
	//java程序调用存储过程
	public List<Myuser> findByPage(int page,int pageSize){
		//java优化：尽量加0
		List<Myuser> emps = new ArrayList<Myuser>(0);
		Connection conn = null;
		//preCallableStatement
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareCall("{call kzPage103.findByPage(?,?,?)}");
			//给输入参数占位符赋值
			st.setInt(1, page);
			st.setInt(2,pageSize);
			//st.setString(3,"emp");
			//给输出参数赋值
			st.registerOutParameter(3,OracleTypes.CURSOR);
			
			//执行   st.execteUpdate();
			st.execute();
			rs  = (ResultSet) st.getObject(3);
			while(rs.next()){
				Myuser user =new Myuser();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setPassword(rs.getString("Password"));
				//加入集合
				emps.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return emps;
	}
	
	public static void main(String[] args) {
		List<Myuser> emps = new MyuserDao().findByPage(2,5);
		for(Myuser emp :emps){
			System.out.println(emp);
		}
		new MyuserDao().testFun(10000);
	}
}
