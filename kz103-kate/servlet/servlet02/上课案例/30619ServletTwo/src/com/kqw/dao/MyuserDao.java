package com.kqw.dao;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import entity.Myuser;
//oracle�Ż�----�������
public class MyuserDao {
	//java���ô洢����
	public void testFun(int year){
		Connection conn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareCall("{?=call kz103.loveYou(?)}");
			//��ռλ����ֵ
			//����ֵ��out
			st.registerOutParameter(1,OracleTypes.VARCHAR);
			//������in
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
	//java������ô洢����
	public List<Myuser> findByPage(int page,int pageSize){
		//java�Ż���������0
		List<Myuser> emps = new ArrayList<Myuser>(0);
		Connection conn = null;
		//preCallableStatement
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareCall("{call kzPage103.findByPage(?,?,?)}");
			//���������ռλ����ֵ
			st.setInt(1, page);
			st.setInt(2,pageSize);
			//st.setString(3,"emp");
			//�����������ֵ
			st.registerOutParameter(3,OracleTypes.CURSOR);
			
			//ִ��   st.execteUpdate();
			st.execute();
			rs  = (ResultSet) st.getObject(3);
			while(rs.next()){
				Myuser user =new Myuser();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setPassword(rs.getString("Password"));
				//���뼯��
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
