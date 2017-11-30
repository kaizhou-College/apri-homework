package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.QueryFwxx;
import com.kz.entity.Tbl_fwxx;

public class QueryFwxxDao {
	//非空判断
	public boolean strIsNull(String str){
		if (str!=null&&str.trim().length()>0) {
			return true;
		}
		return false;
	}
	//分页查询
	public <T> List<T> findByUQSM(Class<Tbl_fwxx> clazz,int page,int pageSize,QueryFwxx qf,Object uid){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		int max = page*pageSize;
		try {
			conn = BaseDao.getConn();
			StringBuffer sql=new StringBuffer("select * from (select rownum rn,t.* from (select * from ");
			sql.append(clazz.getSimpleName()+" where 1=1 ");
			if (strIsNull(qf.getTitle())) {
				sql.append(" and title like '%"+qf.getTitle()+"%'");
			}
		
			if (qf.getJdid()==1){
				sql.append(" and jdid=1");
			}else if(qf.getJdid()==2){
				sql.append(" and jdid=2");
			}else if(qf.getJdid()==3){
				sql.append(" and jdid=3");
			}else if(qf.getJdid()==4){
				sql.append(" and jdid=4");
			}else if(qf.getJdid()==5){
				sql.append(" and jdid=5");
			}else if(qf.getJdid()==6){
				sql.append(" and jdid=6");
			}else if(qf.getJdid()==7){
				sql.append(" and jdid=7");
			}else if(qf.getJdid()==8){
				sql.append(" and jdid=8");
			}else if(qf.getJdid()==9){
				sql.append(" and jdid=9");
			}else{
				sql.append("");
			}
			
			//如果开始资金和结束资金都不为空
			if (strIsNull(qf.getStartzj())&&strIsNull(qf.getEndzj())) {
				sql.append(" and zj between "+qf.getStartzj()+" and "+qf.getEndzj());
			}
			//房屋户型
			if (qf.getShi()==1) {
				sql.append(" and shi=1");
			}else if (qf.getShi()==2) {
				sql.append(" and shi=2");
			}else if (qf.getShi()==3) {
				sql.append(" and shi=3");
			}else if (qf.getShi()==4) {
				sql.append(" and shi=4");
			}else if (qf.getShi()==5) {
				sql.append(" and shi=5");
			}else if (qf.getShi()==6) {
				sql.append(" and shi=6");
			}else if (qf.getShi()==7) {
				sql.append(" and shi=7");
			}else if (qf.getShi()==8) {
				sql.append(" and shi=8");
			}else if (qf.getShi()==9) {
				sql.append(" and shi=9");
			}else{
				sql.append("");
			}
			//厅
			if (qf.getTing()==1) {
				sql.append(" and ting=1");
			}else if (qf.getTing()==2) {
				sql.append(" and ting=2");
			}else if (qf.getTing()==3) {
				sql.append(" and ting=3");
			}else if (qf.getTing()==4) {
				sql.append(" and ting=4");
			}else if (qf.getTing()==5) {
				sql.append(" and ting=5");
			}else{
				sql.append("");
			}
			//房屋类型
			if (qf.getLxid()!=null) {
				if (qf.getLxid()==1) {
					sql.append(" and lxid=1");
				}else if (qf.getLxid()==2) {
					sql.append(" and lxid=2");
				}else if (qf.getLxid()==3) {
					sql.append(" and lxid=3");
				}else if (qf.getLxid()==4) {
					sql.append(" and lxid=4");
				} else if (qf.getLxid()==5){
					sql.append(" and lxid=5");
				}else{
					sql.append("");
				}
			}else{
				sql.append("");
			}
			//发布时间
			if (strIsNull(qf.getQueryDate())) {
				if (qf.getQueryDate().equals("1")) {
					sql.append(" and publishdate=sysdate");
				}else if (qf.getQueryDate().equals("2")) {
					sql.append(" and publishdate between sysdate and (sysdate+2)");
				}else if (qf.getQueryDate().equals("3")) {
					sql.append(" and publishdate between sysdate and (sysdate+3)");
				
				}else if (qf.getQueryDate().equals("7")) {
					sql.append(" and publishdate between sysdate and (sysdate+7)");
				}else if (qf.getQueryDate().equals("14")) {
					sql.append(" and publishdate between sysdate and (sysdate+14)");
				}else if (qf.getQueryDate().equals("30")) {
					sql.append(" and publishdate between sysdate and (sysdate+30)");
				}else{
					sql.append("");
			}
			}
			sql.append(") t where uuid=?) where rn>? and rn<=?");
			System.out.println(sql.toString());
			pst = conn.prepareStatement(sql.toString());
			pst.setObject(1, uid);
			pst.setInt(2, min);
			pst.setInt(3,max);
			rs = pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						if (field.getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
						
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs,pst,conn);
		}
		return list;
	}
	//求最大页数select * from (select * from Tbl_fwxx where 1=1  and zj between 5000 and 15000)
	public <T> int MaxPage(Class<Tbl_fwxx> clazz,int page,int pageSize,QueryFwxx qf,Object uid){
		int num=-1;
		List<T> list=null;
		StringBuffer sql=new StringBuffer("select * from (select * from ");
		sql.append(clazz.getSimpleName()+" where 1=1 ");
		if (strIsNull(qf.getTitle())) {
			sql.append(" and title like '%"+qf.getTitle()+"%'");
		}
	
		if (qf.getJdid()==1){
			sql.append(" and jdid=1");
		}else if(qf.getJdid()==2){
			sql.append(" and jdid=2");
		}else if(qf.getJdid()==3){
			sql.append(" and jdid=3");
		}else if(qf.getJdid()==4){
			sql.append(" and jdid=4");
		}else if(qf.getJdid()==5){
			sql.append(" and jdid=5");
		}else if(qf.getJdid()==6){
			sql.append(" and jdid=6");
		}else if(qf.getJdid()==7){
			sql.append(" and jdid=7");
		}else if(qf.getJdid()==8){
			sql.append(" and jdid=8");
		}else if(qf.getJdid()==9){
			sql.append(" and jdid=9");
		}else{
			sql.append("");
		}
		
		//如果开始资金和结束资金都不为空
		if (strIsNull(qf.getStartzj())&&strIsNull(qf.getEndzj())) {
			sql.append(" and zj between "+qf.getStartzj()+" and "+qf.getEndzj());
		}
		//房屋户型
		if (qf.getShi()==1) {
			sql.append(" and shi=1");
		}else if (qf.getShi()==2) {
			sql.append(" and shi=2");
		}else if (qf.getShi()==3) {
			sql.append(" and shi=3");
		}else if (qf.getShi()==4) {
			sql.append(" and shi=4");
		}else if (qf.getShi()==5) {
			sql.append(" and shi=5");
		}else if (qf.getShi()==6) {
			sql.append(" and shi=6");
		}else if (qf.getShi()==7) {
			sql.append(" and shi=7");
		}else if (qf.getShi()==8) {
			sql.append(" and shi=8");
		}else if (qf.getShi()==9) {
			sql.append(" and shi=9");
		}else{
			sql.append("");
		}
		//厅
		if (qf.getTing()==1) {
			sql.append(" and ting=1");
		}else if (qf.getTing()==2) {
			sql.append(" and ting=2");
		}else if (qf.getTing()==3) {
			sql.append(" and ting=3");
		}else if (qf.getTing()==4) {
			sql.append(" and ting=4");
		}else if (qf.getTing()==5) {
			sql.append(" and ting=5");
		}else{
			sql.append("");
		}
		//房屋类型
		if (qf.getLxid()!=null) {
			if (qf.getLxid()==1) {
				sql.append(" and lxid=1");
			}else if (qf.getLxid()==2) {
				sql.append(" and lxid=2");
			}else if (qf.getLxid()==3) {
				sql.append(" and lxid=3");
			}else if (qf.getLxid()==4) {
				sql.append(" and lxid=4");
			} else{
				sql.append(" and lxid=5");
			}
		}else{
			sql.append("");
		}
		//发布时间
		if (strIsNull(qf.getQueryDate())) {
			if (qf.getQueryDate().equals("1")) {
				sql.append(" and publishdate=sysdate");
			}else if (qf.getQueryDate().equals("2")) {
				sql.append(" and publishdate between sysdate and (sysdate+2)");
			}else if (qf.getQueryDate().equals("3")) {
				sql.append(" and publishdate between sysdate and (sysdate+3)");
			
			}else if (qf.getQueryDate().equals("7")) {
				sql.append(" and publishdate between sysdate and (sysdate+7)");
			}else if (qf.getQueryDate().equals("14")) {
				sql.append(" and publishdate between sysdate and (sysdate+14)");
			}else if (qf.getQueryDate().equals("30")) {
				sql.append(" and publishdate between sysdate and (sysdate+30)");
			}else{
				sql.append("");
		}
		}
		sql.append(") where uuid=?");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn=BaseDao.getConn();
			pst = conn.prepareStatement(sql.toString());
			pst.setObject(1, uid);
			rs = pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						if (field.getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
						
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs,pst,conn);
		}
		int size = list.size();
		num=(size-1)/pageSize+1;
		return num;
	}
	public static void main(String[] args) {
		QueryFwxxDao qfd=new QueryFwxxDao();
		QueryFwxx qf=new QueryFwxx();
		/*qf.setTitle("学区");
		qf.setQueryDate("4");*/
		qf.setJdid(0);
		qf.setShi(0);
		qf.setTing(0);
		qf.setLxid(0);
		qf.setStartzj("5000");
		qf.setEndzj("15000");
		System.out.println(qfd.findByUQSM(Tbl_fwxx.class, 1, 4, qf,1));
		System.out.println(qfd.MaxPage(Tbl_fwxx.class, 1, 2, qf,1));
	}
}
