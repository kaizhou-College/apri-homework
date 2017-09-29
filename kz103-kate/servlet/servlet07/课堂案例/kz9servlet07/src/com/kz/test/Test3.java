package com.kz.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//连接数据库
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin://127.0.0.1:1521:orcl";
		String name= "scott";
		String pwd = "tiger";
		//系统当前时间到1970-1-1午夜的时间差 单位是毫秒
		Long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			Connection con = DriverManager.getConnection(url,name,pwd);
			//增删改查
			//..........
			con.close();//销毁Connection类对象 conn不再连接到数据
		}
		Long end = System.currentTimeMillis();
		System.out.println("获取传统方式得到1w个连接的时间"+(end-start));
		
		
		
	}
}
