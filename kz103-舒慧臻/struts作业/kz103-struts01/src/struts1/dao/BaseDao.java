package struts1.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class BaseDao<T> {
	//��������
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","abc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//�ر�����
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(st!=null){
				st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ͨ�ò�ѯ
	public static List queryAll(Class clazz){
		List list =null;
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		//�õ�����
		Connection conn = BaseDao.getConn();
		PreparedStatement st =null; 
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list = new ArrayList();
			while(rs.next()){
				Object obj = clazz.newInstance();
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
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//ͨ�����
	public static int add(String key,Object obj){
		//insert into ����(�ֶ���) values(key.nextval,�ֶ���)
		StringBuffer sql = new StringBuffer();	
		Class clazz = obj.getClass();
		sql.append("insert into "+clazz.getSimpleName()+"(");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(fields[0].getName()+",");
		int count=0;
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				count++;
				sql.append(fields[i].getName()+",");
			}
		}
		String string = sql.substring(0,sql.lastIndexOf(","));
		StringBuffer sql1 = new StringBuffer(string);
		sql1.append(") values("+key+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				sql1.append("?");
				if(i<count){
					sql1.append(",");
				}
			}
		}
		sql1.append(")");
		System.out.println(sql1.toString());
		//�õ�����
		Connection conn = null;
		PreparedStatement st = null;
		int num=-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql1.toString());
			for(int i =1;i<fields.length;i++){
				Object value = fields[i].get(obj);
				if(value instanceof Integer){
					value = ((Integer)value).intValue();
				}
				if(value ==null){
					continue;
				}
				st.setObject(i,value);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql1.toString());
		return num;
	}
	//��ҳ��ѯ
	public static List queryByPage(int index,int page,Class clazz){
		/*SELECT * FROM                         
		(SELECT ROWNUM rn ,e.* FROM emp e WHERE ROWNUM<=index*page)
		WHERE rn>index-1*page;*/
		StringBuffer sql =new StringBuffer();
		sql.append("select * from (select rownum rn,t.* from "+clazz.getSimpleName()+" t ");
		sql.append("where rownum<="+index*page+")");
		sql.append(" where rn>"+(index-1)*page);
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		System.out.println(sql.toString());
		//��������
		List list = new ArrayList(0);
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value ==null){
						continue;
					}
					fields[i].set(obj, value);
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//�õ�����
	public static int getCount(Class clazz){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from "+clazz.getSimpleName());
		//�õ�����
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		int num =-1;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			num = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}
	//�õ������
	public static int getMax(int size,Class clazz){
		double num=getCount(clazz)/(size*1.0);
		int max = (int) Math.ceil(num);
		return max;
	}
	
	public static void main(String[] args) {
		//��ѯ���в���
//		List list = queryAll(Users1.class);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		////��Ӳ���
//		Message m = new Message("��Ů����","��Ҫ����","��Ů","09-9��-2017",0);
//		System.out.println(add("seq_mes",m));
		//��ҳ����
//		List list = queryByPage(1,5,Message.class);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		//�õ���������
//		System.out.println(getCount(Users1.class));
		//�õ����ֵ����
//		System.out.println(getMax(7,Users1.class));
	}

}
