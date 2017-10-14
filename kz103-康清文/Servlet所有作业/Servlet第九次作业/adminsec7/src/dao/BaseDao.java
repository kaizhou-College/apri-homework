package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
		public static Connection getConn(){
			Connection conn=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521","scott","abc");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				return conn;
			}
			

}
