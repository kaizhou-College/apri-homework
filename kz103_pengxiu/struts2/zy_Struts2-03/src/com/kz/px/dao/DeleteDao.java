package com.kz.px.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
	public static int delete(Object obj){
		int num=-1;
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer buff=new StringBuffer("delete from "+class1.getSimpleName()+" where ");
		String string="class java.lang.String";
		for (int i = 0; i < fields.length; i++) {
			try{
				if(fields[i].get(obj)!=null){
					if(fields[i].getType().toString().length()==string.length()){
						buff.append(fields[i].getName()+" = '"+fields[i].get(obj)+"' and ");
					}else{
						buff.append(fields[i].getName()+" = "+fields[i].get(obj)+" and ");
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-5));
		System.out.println(sql);
		Connection conn = Basedao.getConn();
		PreparedStatement st =null;
		try {
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(null, st, conn);
		}
		return num;
	}
}
