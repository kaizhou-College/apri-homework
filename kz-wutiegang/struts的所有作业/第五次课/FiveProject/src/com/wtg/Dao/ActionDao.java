package com.wtg.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.wtg.entity.Auction;

public class ActionDao {
	//字符串非空判断
	public boolean strIsNull(String content){
		if (content!=null&&content.trim().length()>0) {
			return true;
		}
		return false;
	}
	//高级查询
	public List<Auction> findByNDBEA(Auction auction) throws InstantiationException{
		List<Auction> list=null;
		
		StringBuffer sql=new StringBuffer("select * from Auction where 1=1");
		if (strIsNull(auction.getAuctionname())) {
			sql.append(" and auctionname='"+auction.getAuctionname()+"'");
		}
		if (strIsNull(auction.getAuctiondesc())) {
			sql.append(" and auctiondesc='"+auction.getAuctiondesc()+"'");
		}
		if (strIsNull(auction.getAuctionstarttime())) {
			sql.append(" and auctionstarttime=to_date('"+auction.getAuctionstarttime()+"','yyyy-MM-dd')");
		}
		if (strIsNull(auction.getAuctionendtime())) {
			sql.append(" and auctionendtime=to_date('"+auction.getAuctionendtime()+"','yyyy-MM-dd')");
		}
		if (auction.getAuctionstartprice()!=null) {
			sql.append(" and auctionstartprice='"+auction.getAuctionstartprice()+"'");
		}
		System.out.println(sql.toString());
		Class clazz=Auction.class;
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		Connection conn =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list=new ArrayList<Auction>();
			while (rs.next()) {
				Auction ac = (Auction) clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					fields[i].set(ac, value);
				}
				list.add(ac);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, conn, st);
		}
		
		return list;
	}
	//分页查询
	public List<Auction> selByPage(Auction auction,int page,int pageSize){
		List<Auction> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		
		int max = page*pageSize;
		
		try {
			conn = BaseDao.getConn();
			StringBuffer sql=new StringBuffer("select * from (select rownum num,t.* from (select * from Auction where 1=1");
			if (strIsNull(auction.getAuctionname())) {
				sql.append(" and auctionname='"+auction.getAuctionname()+"'");
			}
			if (strIsNull(auction.getAuctiondesc())) {
				sql.append(" and auctiondesc='"+auction.getAuctiondesc()+"'");
			}
			if (strIsNull(auction.getAuctionstarttime())) {
				sql.append(" and auctionstarttime=to_date('"+auction.getAuctionstarttime()+"','yyyy-MM-dd')");
			}
			if (strIsNull(auction.getAuctionendtime())) {
				sql.append(" and auctionendtime=to_date('"+auction.getAuctionendtime()+"','yyyy-MM-dd')");
			}
			if (auction.getAuctionstartprice()!=null) {
				sql.append(" and auctionstartprice='"+auction.getAuctionstartprice()+"'");
			}
			sql.append(") t) where num>? and num<=?");
			System.out.println(sql.toString());
			pst = conn.prepareStatement(sql.toString());
			pst.setInt(1, min);
			pst.setInt(2,max);
			rs = pst.executeQuery();
			Class clazz=auction.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<Auction>();
			while(rs.next()){
				Auction obj = (Auction) clazz.newInstance();
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, conn, pst);
		}
		
		return list;
	}
	//求高级查询之后的最大页
	public int maxPage(Auction auction,int pageSize){
		int num=-1;
		try {
			num=(findByNDBEA(auction).size()-1)/pageSize+1;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public static void main(String[] args) {
		ActionDao act=new ActionDao();
		Auction auction=new Auction();

		auction.setAuctionstartprice(100);
		
		System.out.println(act.selByPage(auction, 1, 16).size());
	
		//System.out.println(act.maxPage(auction, 2));
		
	}
}
