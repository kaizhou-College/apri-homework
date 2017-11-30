package test.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import test.entity.FwxxDim;
import test.entity.Tbl_Fwxx;


public class FwxxDao {
	// 根据id查询
	public static List queryById(Class clazz, int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		List list = new ArrayList(0);
		sql.append("uuid=?");
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				obj = clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//根据id查两表联查
	public List findById1(Class clazz, int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList(0);
		try {
			conn = BaseDao.getConn();
			/*
			 * select fwid,uuid,a.jdid,a.lxid,shi,ting,fwxx,zj,title,publishdate,telephone,lxr,b.fwlx from Tbl_Fwxx a 
			       inner join Tbl_Fwlx b
			       on a.lxid = b.lxid
			       where a.fwid=2
			 */
			String sql = "select  fwid,uuid,a.jdid,a.lxid,shi,ting,fwxx,zj,title,publishdate,telephone,lxr,b.fwlx from Tbl_Fwxx a inner join Tbl_Fwlx b"
						+" on a.lxid = b.lxid"+" where a.fwid=?";
			System.out.println(sql.toString());
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
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
		} catch (SQLException e) {
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
	//根据房屋ID来查用户ID
	public static int queryById(Object id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select uuid from Tbl_Fwxx");
		sql.append(" where ");
		sql.append("fwid="+id);
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0 ;
			try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				if(rs!=null){
					num = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}
	//高级查询
	public List queryByDim(FwxxDim fw,int index,int size){
		List list = new ArrayList(0);
		StringBuffer sql = new StringBuffer("select * from (select rownum rn,t.* from  Tbl_Fwxx t where 1=1");
		if(fw.getTitle()!=null&&fw.getTitle().trim().length()>0){
			sql.append(" and title like '%"+fw.getTitle()+"%'");
		}
		if(fw.getJdid()!=null){
			sql.append(" and jdid="+fw.getJdid());
		}
		if(fw.getTing()!=null){
			sql.append(" and ting="+fw.getTing());
		}
		if(fw.getShi()!=null){
			sql.append(" and shi="+fw.getShi());
		}
		if(fw.getLxid()!=null){
			sql.append(" and lxid="+fw.getLxid());
		}
		if(fw.getStartzj()!=null){
			sql.append(" and zj>"+fw.getStartzj());
		}
		if(fw.getEndzj()!=null){
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
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st= conn.prepareStatement(sql.toString());
			Class clazz = Tbl_Fwxx.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields,true);
			st.setInt(1,((index-1)*size));
			st.setInt(2,(index*size));
			rs = st.executeQuery();
			while(rs.next()){
				Tbl_Fwxx fz =(Tbl_Fwxx)clazz.newInstance();
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
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	public int getCount(FwxxDim fw){//查询高级查询有多少数据以便最大页
		StringBuffer sql = new StringBuffer("select count(*) from (select * from tbl_fwxx t where 1=1");
		if(fw.getTitle()!=null&&fw.getTitle().trim().length()>0){
			sql.append(" and title like '%"+fw.getTitle()+"%'");
		}
		if(fw.getJdid()!=null){
			sql.append(" and jdid="+fw.getJdid());
		}
		if(fw.getTing()!=null){
			sql.append(" and ting="+fw.getTing());
		}
		if(fw.getShi()!=null){
			sql.append(" and shi="+fw.getShi());
		}
		if(fw.getLxid()!=null){
			sql.append(" and lxid="+fw.getLxid());
		}
		if(fw.getStartzj()!=null){
			sql.append(" and zj>"+fw.getStartzj());
		}
		if(fw.getEndzj()!=null){
			sql.append(" and zj<"+fw.getEndzj());
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count =-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(new FwxxDao().findById1(Tbl_Fwxx.class, 2));
	}
}
