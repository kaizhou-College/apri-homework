package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.BaseDao;


public class Userimpl {
	public void User(){
	Connection conn=null;
	ResultSet rs=null;
	Statement st=null;
	try {
		conn=BaseDao.getConn();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
