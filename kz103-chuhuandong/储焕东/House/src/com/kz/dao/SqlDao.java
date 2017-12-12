package com.kz.dao;

import java.lang.reflect.Field;
import java.sql.Timestamp;

public class SqlDao {
	public static String UpdateSql(Field[] fields,Object obj,int id){
		StringBuffer sql = new StringBuffer();
		sql.append("Update "+obj.getClass().getSimpleName()+" set ");
		for (int i = 1; i < fields.length; i++) {
			Object value=null;
			try {
				value = fields[i].get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(!(value instanceof Double)&&!(value instanceof Integer)){
				if(value!=null){
					if(fields[i].getName().contains("time")){
						sql.append(fields[i].getName()+"=to_date(?,'yyyy-MM-dd hh24:mi:ss')");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}else{
						sql.append(fields[i].getName()+"=?");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}
			}else{
				if(value instanceof Double){
					if((Double)value!=0){
						sql.append(fields[i].getName()+"=?");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}else if(value instanceof Integer){
					if((Integer)value!=0){
						sql.append(fields[i].getName()+"=?");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}
			}
		}
		try {
			if(fields[fields.length-1].get(obj)==null){
				sql = new StringBuffer(sql.substring(0, sql.length()-1));
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		sql.append(" where "+fields[0].getName()+"="+id);
		return sql.toString();
	}
	
	public static String Sql(Field[] fields,Object obj,String seq){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into "+obj.getClass().getSimpleName()+"("+fields[0].getName()+",");
		for (int i = 1; i < fields.length; i++) {
			Object value=null;
			try {
				value = fields[i].get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(!(value instanceof Double)&&!(value instanceof Integer)){
				if(value!=null){
					sql.append(fields[i].getName());
					if(i!=fields.length-1){
						sql.append(",");
					}
				}
			}else{
				if(value instanceof Double){
					if((Double)value!=0){
						sql.append(fields[i].getName());
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}else if(value instanceof Integer){
					if((Integer)value!=0){
						sql.append(fields[i].getName());
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}
			}
		}
		try {
			if(fields[fields.length-1].get(obj)==null){
				System.out.println("??");
				sql = new StringBuffer(sql.substring(0, sql.length()-1));
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		sql.append(") values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			Object value=null;
			try {
				value = fields[i].get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(!(value instanceof Double)&&!(value instanceof Integer)){
				if(value!=null){
					sql.append("?");
					if(i!=fields.length-1){
						sql.append(",");
					}
				}
			}else{
				if(value instanceof Double){
					if((Double)value!=0){
						sql.append("?");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}else if(value instanceof Integer){
					if((Integer)value!=0){
						sql.append("?");
						if(i!=fields.length-1){
							sql.append(",");
						}
					}
				}
			}
		}
		try {
			if(fields[fields.length-1].get(obj)==null){
				System.out.println("??");
				sql = new StringBuffer(sql.substring(0, sql.length()-1));
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		sql.append(")");
		return sql.toString();
	}
}
