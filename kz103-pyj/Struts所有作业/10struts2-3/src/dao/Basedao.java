package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Orders;

public class Basedao {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl","scott","pyj795");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//�������
	public static int save(String seq,Object o){
		int num=-1;
		StringBuffer sql=new StringBuffer("insert into "); 
		Class clazz = o.getClass();
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		Connection conn=null;
		PreparedStatement st=null;
		try {
			//��������ݿ������
			 conn = Basedao.getConn();
			 //����һ��Statement����
			 st=conn.prepareStatement(sql.toString());
			 //��ռλ����ѭ����ֵ
			 for (int i = 1; i < fields.length; i++) {
				Object zhi = fields[i].get(o);
				st.setObject(i, zhi);
			}
			 //��ʼ���
			 num=st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	} 
//ɾ��
	public static int del(Class clazz,int id){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from ");
		Connection conn = Basedao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" where "+fields[0].getName()+"="+id);
		PreparedStatement st = null;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sql.toString());
		return num;
	}
//�����
	//�޸������
	public static int update(Object obj){
		StringBuffer sql = new StringBuffer();
		//�жϴ����������Ƿ�Ϊ��
		sql.append("update ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" set ");
		for (int i = 1; i < fields.length; i++) {
			try {
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					sql.append(fields[i].getName()+" =?,");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		StringBuffer sql2 = new StringBuffer(sql.substring(0,sql.length()-1));
		sql2.append(" where "+fields[0].getName()+"=?");
		//�õ�����
		Connection conn = null;
		PreparedStatement st = null;
		int index=0;
		int num = -1;
		try {
			conn = Basedao.getConn();
			st = conn.prepareStatement(sql2.toString());
			for (int i = 1; i < fields.length; i++) {
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					index++;
					st.setObject(index,fields[i].get(obj));
				}
			}
			st.setObject(index+1,fields[0].get(obj));
			num = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			Basedao.closeConn(null, st, conn);
		}
		return num;
	}
	public static void main(String[] args) {
		Basedao bd=new Basedao();
		//��
		/*Users  u=new Users();
		u.setUsername("��Ůʿ");
		u.setUserpwd("2464");
		System.out.println(bd.save("seq_users", u));*/
		//��
/*		Orders o=new Orders();
		o.setOrdered(7);
		o.setProdname("���ȴ����");
		System.out.println(bd.update(o));*/
		//��
/*		List list=bd.find(Orders.class);
		for (Object obj : list) {
			Orders o=(Orders)obj;
			System.out.println(o);
		}*/
		//ɾ
	/*	Orders cli=new Orders();
		System.out.println(bd.del(Orders.class, 2));*/
	}
}
