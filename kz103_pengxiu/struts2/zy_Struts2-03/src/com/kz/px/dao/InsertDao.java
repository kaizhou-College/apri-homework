package com.kz.px.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDao {
	public static int save(Object obj,String seq) throws Exception{
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		
		sql.append(" values("+seq+".nextval");
		for(int i=1;i<fields.length;i++){
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = Basedao.getConn();
			st = conn.prepareStatement(sql.toString());
			for(int i =0;i<fields.length;i++){
				Object value = fields[i].get(obj);
				st.setObject(i+1, value);
				System.out.println("Öµ"+value+"´ÎÊý"+i);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeConn(null, st, conn);
		}
		return num;
	}
}
