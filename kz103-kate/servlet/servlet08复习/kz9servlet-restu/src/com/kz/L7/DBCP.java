package com.kz.L7;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
public class DBCP {//database connection pool 数据库连接池技术
	public static void main(String[] args) throws SQLException {
		  BasicDataSource bds = new BasicDataSource();
		  bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		  bds.setUrl("jdbc:oracle:thin://localhost:1521:orcl");
		  bds.setUsername("scott");
		  bds.setPassword("tiger");
		  bds.setMaxActive(200);
		  //bds.setInitialSize(2);
		  bds.setMaxIdle(10);
		  
		  Connection conn = bds.getConnection();
		  System.out.println(conn);
		  conn.close();//不是真正的关闭，只是重新放回连接池
	}  
	
}

