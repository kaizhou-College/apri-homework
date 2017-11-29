package com.kz.examination.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kz.examination.entity.TBL_JD;
import com.kz.examination.entity.TBL_QX;
import com.kz.examination.utils.Returns;

public class TBL_JDDao {
	public static List<TBL_JD> listQXid(int id){
		String sql="select * from tbl_jd where qxid="+id;
		List<TBL_JD> list = new Returns().returnList(new TBL_JD(), sql);
		return list;
	}
	public static List<TBL_JD> listQXid(String  id){
		String sql="select * from tbl_qx where qx='"+id+"'";
//		System.out.println(sql);
		List<TBL_JD> list = new Returns().returnList(new TBL_QX(), sql);
		return list;
	}
	public static List<TBL_QX> listQX(){
		String sql="select * from tbl_qx ";
//		System.out.println(sql);
		Connection conn =new Returns().getConn();
		PreparedStatement st =null;
		ResultSet rs = null;
		List list=null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list=new ArrayList();
			while (rs.next()) {
				 String string = rs.getString("qx");
				 list.add(string);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<TBL_JD> listJDid(String  id){
		String sql="select * from tbl_jd where jd='"+id+"'";
//		System.out.println(sql);
		List<TBL_JD> list = new Returns().returnList(new TBL_JD(), sql);
		return list;
	}
	
	public static List<TBL_JD> JdQxidLIst(int id){
		String sql="select t.jd from tbl_jd t where qxid in (select qxid from tbl_jd where jdid="+id+")";
//		System.out.println(sql);
		Connection conn =new Returns().getConn();
		PreparedStatement st =null;
		ResultSet rs = null;
		List list=null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list=new ArrayList();
			while (rs.next()) {
				 String string = rs.getString("jd");
				 list.add(string);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public static List<TBL_JD> JdQuLIst(String id){
		String sql="select t.jd from tbl_jd t where qxid in (select qxid from tbl_qx where qx='"+id+"')";
//		System.out.println(sql);
		Connection conn =new Returns().getConn();
		PreparedStatement st =null;
		ResultSet rs = null;
		List list=null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list=new ArrayList();
			while (rs.next()) {
				 String string = rs.getString("jd");
				 list.add(string);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		List jdQxidLIst = TBL_JDDao.listQX();
		for (int i = 0; i < jdQxidLIst.size(); i++) {
			System.out.println(jdQxidLIst.get(i));
		}
	}
}
