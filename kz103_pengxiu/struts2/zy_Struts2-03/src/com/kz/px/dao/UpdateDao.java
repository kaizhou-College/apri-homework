package com.kz.px.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kz.px.entity.orders;

public class UpdateDao {
	public static int update(Object obj){
		int num=-1;
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("update "+class1.getSimpleName()+" set  ");
		StringBuffer sql=null;
		String string="class java.lang.String";
			try {
				for (int i = 1; i < fields.length; i++) {
					if(fields[i].get(obj)!=null){
						if(fields[i].getType().toString().length()==string.length()){
							buff.append(fields[i].getName()+" = '"+fields[i].get(obj)+"' ,");
						}else{
							buff.append(fields[i].getName()+" = "+fields[i].get(obj)+" ,");
						}
					}
				}
				sql=new StringBuffer(buff.substring(0,buff.length()-1)+" where "+fields[0].getName()+"="+fields[0].get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.println(sql);
			Connection conn = Basedao.getConn();
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(sql.toString());
				num = st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return num;
	}
	public static void main(String[] args) {
		orders o=new orders();
		o.setCustname("a");
		o.setOrdercount(3);
		o.setOrderdate("12-11ÔÂ-13");
		o.setOrdered(123);
		o.setProdname("12");
		System.out.println(update(o));
		
	}
}
