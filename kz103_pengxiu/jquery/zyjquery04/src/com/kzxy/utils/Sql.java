package com.kzxy.utils;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Sql {
	//��ͨ�� ��ѯȫ�� ��id��ѯ ��ҳ��ѯ  ��ѯ����  ��sql���?
	public  String selectSql(Object obj, int divisionSelect,
			int pageIndex, int pageSize) {
		StringBuffer sql = null;// sql���ƴ��?
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		if (divisionSelect == 1) {// ��ѯȫ��
			sql = new StringBuffer("select  ");
			for (int i = 0; i < fields.length; i++) {
				try {
					sql.append(fields[i].getName());
					if (i != fields.length - 1) {
						sql.append(",");
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			sql.append(" from " + class1.getSimpleName());
		} else if (divisionSelect == 2) {// ����id��ѯ
			sql = new StringBuffer("select  ");
			for (int i = 0; i < fields.length; i++) {
				try {
					sql.append(fields[i].getName());
					if (i != fields.length - 1) {
						sql.append(",");
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			try {
				sql.append(" from " + class1.getSimpleName() + " where "
						+ fields[0].getName() + " = " + fields[0].get(obj));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (divisionSelect == 3) {// ��ҳ��ѯ
			sql = new StringBuffer("select * from (select rownum rn,t.* from "
					+ "" + class1.getSimpleName() + " t)where  rn>"
					+ ((pageIndex - 1) * pageSize) + " and " + "rn<="
					+ pageIndex * pageSize + "" + " order by "
					+ fields[0].getName() + " desc ");

		} else if (divisionSelect == 4) {// ��ѯ����
			sql = new StringBuffer().append("select count(*) from "
					+ class1.getSimpleName());
		} else {
			sql = new StringBuffer().append(" Ŀǰֻ��1 2 3 4�ַ��� ");
		}
		return sql.toString();
	}
	
	//��ͨ�� ��id�޸� ��idɾ�� ���? sql���?
	public String UIDSql(Object obj,int division,String sqlNextval){
		StringBuffer sql=null;
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		try {
		if(division == 1){//�޸�v
			sql=new StringBuffer(" update "+class1.getSimpleName()+" set ");
			for (int i = 1; i < fields.length; i++) {
					
						if(fields[i].get(obj)!=null){
							if(fields[i].getType().toString().length()=="class java.lang.String".length()){
								sql.append(fields[i].getName()+" = '"+fields[i].get(obj)+"',");
							}else{
								sql.append(fields[i].getName()+" = "+fields[i].get(obj)+",");
							}
						}
					
			}
			sql=new StringBuffer(sql.substring(0,sql.length()-1)+" where "+fields[0].getName()+" = "+fields[0].get(obj));
		}else if(division==2){//���?
			sql=new StringBuffer("insert into "+class1.getSimpleName()+"("+fields[0].getName()+",");
			for (int i = 1; i < fields.length; i++) {
				if(fields[i].get(obj)!=null){
					sql.append(fields[i].getName());
					if(i<fields.length-1){
						sql.append(",");
					}else{
						sql.append(") values("+sqlNextval+".nextval");
					}
				}
			}
			for (int i = 1; i < fields.length; i++) {
				if(fields[i].get(obj)!=null){
					if(i<fields.length){
						sql.append(",");
					}
					if(fields[i].getType().toString().length()=="class java.lang.String".length()){
						sql.append("'"+fields[i].get(obj)+"'");
					}else{
						sql.append(fields[i].get(obj));
					}
				}
			}
			sql.append(")");
		}else if(division==3){//ɾ��
			sql=new StringBuffer("delete from "+class1.getSimpleName()+" where "+fields[0].getName()+"="+fields[0].get(obj));
		}else{
			sql=new StringBuffer(" Ŀǰֻ��1��id�޸� 2��idɾ�� 3���?����");
		}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql.toString();
	}
	
	
	
	/*
	 * "select * from (select rownum rn,t.* from " + "" + class1.getSimpleName()
	 * + " t)where  rn>" + ((pageIndex - 1) * pageSize) + " and " + "rn<=" +
	 * pageIndex * pageSize + "" + " order by " + fields[0].getName() + " desc "
	 */
}
