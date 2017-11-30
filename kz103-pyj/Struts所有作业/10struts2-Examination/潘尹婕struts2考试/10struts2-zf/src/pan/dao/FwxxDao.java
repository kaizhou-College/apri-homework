package pan.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import pan.entity.FwxxSenior;
import pan.entity.Tbl_fwxx;

public class FwxxDao {

	public List querySen(FwxxSenior fs, int pageIndex, int pageSize) {
		//高级查询
			List list = new ArrayList(0);
			StringBuffer sql = new StringBuffer("select * from (select rownum rn,t.* from  tbl_fwxx t where 1=1");
			if(fs.getTitle()!=null&&fs.getTitle().trim().length()>0){
				sql.append(" and title like '%"+fs.getTitle()+"%'");
			}
			if(fs.getTing()!=null){
				sql.append(" and ting="+fs.getTing());
			}
			if(fs.getShi()!=null){
				sql.append(" and shi="+fs.getShi());
			}
			if(fs.getLxid()!=null){
				sql.append(" and lxid="+fs.getLxid());
			}
			if(fs.getStartzj()!=null){
				sql.append(" and zj>"+fs.getStartzj());
			}
			if(fs.getEndzj()!=null){
				sql.append(" and zj<"+fs.getEndzj());
			}
			if(fs.getTime()!=null){
				if(fs.getTime()==1){
					sql.append(" and publishdate=trunc(publishdate)+(INTERVAL '0' DAY) ");
				}
				if(fs.getTime()==2){
					sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-2' DAY) ");
				}
				if(fs.getTime()==3){
					sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-3' DAY)  ");
				}
				if(fs.getTime()==4){
					sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-7' DAY)  ");
				}
				if(fs.getTime()==5){
					sql.append(" and publishdate>trunc(publishdate)+(INTERVAL '-14' DAY)  ");
				}
				if(fs.getTime()==6){
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
				Class clazz = Tbl_fwxx.class;
				Field[] fields = clazz.getDeclaredFields();
				Field.setAccessible(fields,true);
				st.setInt(1,((pageIndex-1)*pageSize));
				st.setInt(2,(pageIndex*pageSize));
				rs = st.executeQuery();
				while(rs.next()){
					Tbl_fwxx fz =(Tbl_fwxx)clazz.newInstance();
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
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(rs, st, conn);
			}
			return list;
		}
		public int getCount(FwxxSenior fs){//查询高级查询有多少数据以便最大页
			StringBuffer sql = new StringBuffer("select count(*) from (select * from tbl_fwxx t where 1=1");
			if(fs.getTitle()!=null&&fs.getTitle().trim().length()>0){
				sql.append(" and title like '%"+fs.getTitle()+"%'");
			}
			if(fs.getTing()!=null){
				sql.append(" and ting="+fs.getTing());
			}
			if(fs.getShi()!=null){
				sql.append(" and shi="+fs.getShi());
			}
			if(fs.getLxid()!=null){
				sql.append(" and lxid="+fs.getLxid());
			}
			if(fs.getStartzj()!=null){
				sql.append(" and zj>"+fs.getStartzj());
			}
			if(fs.getEndzj()!=null){
				sql.append(" and zj<"+fs.getEndzj());
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
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(rs, st, conn);
			}
			return count;
		}
}