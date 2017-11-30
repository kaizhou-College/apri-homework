package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.FwxxDim;
import entity.Tbl_Fwxx;

public class FwxxDao {
	public List queryByUid(int uid){
		String sql = "select * from tbl_fwxx where uuid=?";
		List list = new ArrayList(0);
		Class clazz=Tbl_Fwxx.class;
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			st.setInt(1,uid);
			rs = st.executeQuery();
			while (rs.next()) {
				Tbl_Fwxx fw = new Tbl_Fwxx();
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
					fields[i].set(fw, value);
				}
				list.add(fw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//高级查询
	public List queryByDim(FwxxDim fw,int index,int size){
		List list = new ArrayList(0);
		StringBuffer sql = new StringBuffer("select * from (select rownum rn,t.* from  Tbl_Fwxx t where 1=1");
		if(fw.getTitle()!=null&&fw.getTitle().trim().length()>0){
			sql.append(" and title like '%"+fw.getTitle()+"%'");
		}
		if(fw.getQxid()!=null){
			sql.append(" and qxid="+fw.getQxid());
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
		if(fw.getQxid()!=null){
			sql.append(" and qxid="+fw.getQxid());
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
		FwxxDim dim = new FwxxDim();
		dim.setTitle("oh");
		dim.setTime(1);
		System.out.println(new FwxxDao().queryByDim(dim,1,1));
		System.out.println(new FwxxDao().getCount(dim));
	}
}
