package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Users;

public class UsersDao {
	//�����ݿ��Ƿ���ڴ���
	public Boolean find(Users user){
		Connection conn=Basedao.getConn();
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			 String sql = "select count(*) from users where username=? and userpwd=?";
			 st = conn.prepareStatement(sql);
			 st.setString(1,user.getUsername());
			 st.setString(2,user.getUserpwd());
			 //��ѯ
			 rs=st.executeQuery();
			 while(rs.next()){//��ȡ��
				int num = rs.getInt(1);
				if(num>0){
					 return true;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, st, conn);
		}
		return false;
	}
	//��Order���е�����
	public static List select(Object obj) throws Exception{
		List list=new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer str=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			str.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(str.substring(0,str.length()-1)+" from "+class1.getSimpleName());
		System.out.println(sql);
		Connection conn = Basedao.getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object = class1.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value=((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(object, value);
				}
				list.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, st, conn);
		}
		return list;
	}
	//����
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
	//���Բ�ѯ
/*	public static void main(String[] args) {
		Users user = new Users();
		user.setUsername("�����");
		user.setUserpwd("2464");
		System.out.println(new UsersDao().find(user ));
	}*/
}
