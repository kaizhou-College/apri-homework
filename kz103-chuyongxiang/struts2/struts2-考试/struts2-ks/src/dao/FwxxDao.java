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


import web.action.FwxxAction;


import entity.SuperFwxx;
import entity.Tbl_Fwxx;
import entity.Tbl_Jd;


public class FwxxDao {
	//根据ID查询
	public static Tbl_Fwxx findById(int id) {
		Tbl_Fwxx obj = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		String sql = "select * from Tbl_Fwxx where fwid = ?";
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,id);
			rs = st.executeQuery();
			Class clazz = Tbl_Fwxx.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				obj = new Tbl_Fwxx();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value= ((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//测试根据ID查询
//	public static void main(String[] args) {
//		System.out.println(findById(2));
//	}
	
	
	private static boolean NOTNULL(String context){
		boolean notNull=false;
		if(context!=null&&context.trim().length()!=0){
			notNull=true;
		}
		return notNull;
	}
	
	
	//高级查询
	public List<Tbl_Fwxx> superselect(Tbl_Fwxx fwxx3,SuperFwxx fwxx){
		System.out.println("进入了高级查询的Dao方法");
		List<Tbl_Fwxx> list=null;
		StringBuffer sql=new StringBuffer("select * from tbl_fwxx where 1=1");
		
		
		if(NOTNULL(fwxx.getMohu())){
			sql.append(" and title like '%"+fwxx.getMohu()+"%'");
		}
		
		if(fwxx.getZj()!=0 ){
			sql.append(" and zj >"+fwxx.getZj());
		}
		if(fwxx.getZj1()!=0){
			sql.append(" and zj <"+fwxx.getZj1());
		}
		if(fwxx3.getShi()!=0){
			sql.append(" and shi ="+fwxx3.getShi());
		}
		if(fwxx3.getTing()!=0){
			sql.append(" and ting ="+fwxx3.getTing());
		}
		if(fwxx3.getLxid()!=0){
			sql.append(" and lxid =  "+fwxx3.getLxid());
		}
		if(NOTNULL(fwxx.getFabudate())){
			if(Integer.parseInt(fwxx.getFabudate())==1){
				sql.append(" and publishdate=trunc(sysDate)+(INTERVAL '0' DAY) ");
			}else 
			//前俩天
			if(Integer.parseInt(fwxx.getFabudate())==2){
				sql.append(" and publishdate>trunc(sysDate)+(INTERVAL '-2' DAY) ");
			}else //前三天
				if(Integer.parseInt(fwxx.getFabudate())==3){
				sql.append(" and publishdate>trunc(sysDate)+(INTERVAL '-3' DAY)  ");
			}else //前一周
				if(Integer.parseInt(fwxx.getFabudate())==7){
				sql.append(" and publishdate>trunc(sysDate)+(INTERVAL '-7' DAY)  ");
			}else//前俩周
				if(Integer.parseInt(fwxx.getFabudate())==14){
				sql.append(" and publishdate>trunc(sysDate)+(INTERVAL '-14' DAY)  ");
			}else//前一个月 
				if(Integer.parseInt(fwxx.getFabudate())==30){
				sql.append(" and publishdate>trunc(sysDate)+(INTERVAL '-1' month)  ");
			}

		}
		
		//根据区县
		if(fwxx.getQxid()!=0){
			
			List<Tbl_Jd>  list2 = JdDao.findById2(fwxx.getQxid());
			 System.out.println("list2====="+list2);
				for (int i = 0; i <list2.size(); i++) {
					sql.append(" and JDID = "+list2.get(i).getJdid());
				}
		}
		
		if(fwxx3.getJdid()!=0){
			sql.append(" and jdid ="+fwxx3.getJdid());
		}
		
		
		
		System.out.println("看这个sql=="+sql.toString());
		Class clazz=Tbl_Fwxx.class;
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=BaseDao.getConn();
			st=conn.prepareStatement(sql.toString());
			rs=st.executeQuery();
			list=new ArrayList<Tbl_Fwxx>();
			while(rs.next()){
				Tbl_Fwxx su=(Tbl_Fwxx) clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value=rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					fields[i].set(su, value);
				}
//				System.out.println("su=="+su);
				list.add(su);
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
//		System.out.println("list===="+list);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
