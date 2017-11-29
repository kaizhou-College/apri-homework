package com.kz.examination.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kz.examination.entity.QueryView;
import com.kz.examination.utils.Returns;

public class TBL_QXDao {

	public static List qxIdList(Integer qxid) {
		String sql="select  * from tbl_qx where qxid="+qxid;
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
	public static List qxList() {
		String sql="select  * from tbl_qx ";
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
	public static void main(String[] args) {
		System.out.println(qxList());
	}
}
