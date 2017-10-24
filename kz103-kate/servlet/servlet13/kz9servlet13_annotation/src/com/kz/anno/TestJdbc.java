package com.kz.anno;

import java.sql.Connection;

public class TestJdbc {
	public static void main(String[] args) throws Exception {
		Connection conn  =JDBCUtils.getConn();
		System.out.println(conn);
	}
}
