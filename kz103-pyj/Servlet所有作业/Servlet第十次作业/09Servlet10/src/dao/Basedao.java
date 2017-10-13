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
			conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl", "scott", "pyj795");
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
	public List find(Class c){
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
//��ѯ��������
	public Object load(Class c,int id){
		Object obj=null;
		StringBuffer sql = new StringBuffer();
		//sql��䣺select �ֶ���(����) from ����(����);
		sql.append("select ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName()+" where "+fields[0].getName()+"="+id);
		//�õ�����
		Connection conn = Basedao.getConn();
		PreparedStatement st =null; 
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				 obj = c.newInstance();
				for (Field f : fields) {
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value ==null){
						continue;
					}
					f.set(obj, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, st, conn);
		}
		return obj;
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
	
//Ӳ����(������)
/*	public static int update(Object obj){
		StringBuffer sql = new StringBuffer();
		sql.append("update ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" set ");
		for (int i = 1; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append("=?,");
			}
			if(i==fields.length-1){
				sql.append("=?");
			}
		}
		sql.append(" where "+fields[0].getName()+"=?");
		//�õ�����
		Connection conn = Basedao.getConn();
		PreparedStatement st = null;
		int index=1;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			for (int i = 1; i < fields.length; i++) {
				st.setObject(index,fields[i].get(obj));
				index++;
				if(index==fields.length){
					st.setObject(index,fields[0].get(obj));
				}
			}
			num = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(null, st, conn);
		}
		System.out.println(fields.length);
		System.out.println(sql);
		System.out.println(num);
		return num;
	}*/
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
}
