package com.kz.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//�������ݿ�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin://127.0.0.1:1521:orcl";
		String name= "scott";
		String pwd = "tiger";
		//ϵͳ��ǰʱ�䵽1970-1-1��ҹ��ʱ��� ��λ�Ǻ���
		Long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			Connection con = DriverManager.getConnection(url,name,pwd);
			//��ɾ�Ĳ�
			//..........
			con.close();//����Connection����� conn�������ӵ�����
		}
		Long end = System.currentTimeMillis();
		System.out.println("��ȡ��ͳ��ʽ�õ�1w�����ӵ�ʱ��"+(end-start));
		
		
		
	}
}
