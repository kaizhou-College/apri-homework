package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.FwxxDim;
import com.kz.entity.TBL_FWXX;

public class FwxxDao<T> {
	public List<T> getUser(Class cls,String name){
		List<T> list = new ArrayList<T>();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "select * from "+cls.getSimpleName()+" where title like '%"+name+"%'";
		System.out.println(sql);
		Connection conn = BaseDao.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				T t=null;
				try {
					t = (T) cls.newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					try {
						fields[i].set(t, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<TBL_FWXX> queryByDim(FwxxDim fw,int index,int size){
		List<TBL_FWXX> list = new ArrayList<TBL_FWXX>(0);
		StringBuffer sql = new StringBuffer("select * from (select rownum rn,t.* from  Tbl_Fwxx t where 1=1");
		if(fw.getTitle()!=null&&fw.getTitle().trim().length()>0){
			sql.append(" and title like '%"+fw.getTitle()+"%'");
		}
		if(fw.getJdid()!=0){
			sql.append(" and jdid="+fw.getJdid());
		}
		if(fw.getTing()!=0){
			sql.append(" and ting="+fw.getTing());
		}
		if(fw.getShi()!=0){
			sql.append(" and shi="+fw.getShi());
		}
		if(fw.getLxid()!=0){
			sql.append(" and lxid="+fw.getLxid());
		}
		if(fw.getStartzj()!=0){
			sql.append(" and zj>"+fw.getStartzj());
		}
		if(fw.getEndzj()!=0){
			sql.append(" and zj<"+fw.getEndzj());
		}
		if(fw.getTime()!=null){
			if(fw.getTime()==1){
				sql.append(" and publishdate=trunc(publishdate)+(INTERVAL '0' DAY) ");
			}
			if(fw.getTime()==2){
				sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-2' DAY) ");
			}
			if(fw.getTime()==3){
				sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-3' DAY)  ");
			}
			if(fw.getTime()==4){
				sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-7' DAY)  ");
			}
			if(fw.getTime()==5){
				sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-14' DAY)  ");
			}
			if(fw.getTime()==6){
				sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-1' month)  ");
			}
		}
		sql.append(")where rn>? and rn<=?");
		//建立连接
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st= conn.prepareStatement(sql.toString());
			Class clazz = TBL_FWXX.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields,true);
			st.setInt(1,((index-1)*size));
			st.setInt(2,(index*size));
			rs = st.executeQuery();
			while(rs.next()){
				TBL_FWXX fz =(TBL_FWXX)clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					fields[i].set(fz, value);
				}
				list.add(fz);
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
			BaseDao.Close(rs, st, conn);
		}
		return list;
	}
}
