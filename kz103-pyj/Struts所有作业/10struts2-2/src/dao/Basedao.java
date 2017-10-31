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
//�������/*дһ��ͨ�õ�insert���ķ���public int save(Object o)*/
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
//��ѯ����
	public static List find(Class c){
		List list =null;
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		Field[] fields=c.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName());
		//��������ݿ������
		System.out.println(sql.toString());
		Connection conn=Basedao.getConn();
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			 //����һ��Statement����
			 st = conn.prepareStatement(sql.toString());
			 //��ѯ
			 rs=st.executeQuery();
			 //��װ
			 list=new ArrayList();
			 while(rs.next()){//��ȡ��
				 //����һ������
				 Object obj=c.newInstance();
				 //��ռλ����ѭ����ֵ
				 for (Field f:fields) {//��ȡ��
					Object zhi = rs.getObject(f.getName());
					if(zhi instanceof BigDecimal){
						zhi=((BigDecimal)zhi).intValue(); 
					}
					if(zhi instanceof Timestamp){
						zhi = ((Timestamp)zhi).toString();
					}
					if(zhi==null){
						continue;
					}
					f.set(obj, zhi);
				}
				list.add(obj);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, st, conn);
		}
		return list;
	}
	public static void main(String[] args) {
		Basedao bd=new Basedao();
		//��
		/*Users  u=new Users();
		u.setUsername("��Ůʿ");
		u.setUserpwd("2464");
		System.out.println(bd.save("seq_users", u));*/

		//��
	/*	List list=bd.find(Users.class);
		for (Object obj : list) {
			Users u=(Users)obj;
			System.out.println(u);
		}*/
	}
}

