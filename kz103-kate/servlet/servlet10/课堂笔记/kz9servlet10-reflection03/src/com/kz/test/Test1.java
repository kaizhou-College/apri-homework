package com.kz.test;

import java.util.List;

import com.kz.dao.BaseDao;
import com.kz.entity.StudentInfo;
import com.kz.entity.Users;

public class Test1 {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		BaseDao db = new BaseDao();
		
		/*List list = db.query(Users.class);
		for(Object obj :list){
			Users stu = (Users)obj;
			System.out.println(stu);
		}*/
		//Users u = new Users();
		//u.setSex("Ů");
		//u.setUname("�մ��");
		StudentInfo stu = new StudentInfo();
		stu.setStunumber("10101");
		stu.setStuname("�մ���");
		stu.setStusex("Ů");
		//oracleĬ�����ڸ�ʽ
		stu.setStujointime("12-5��-17");
		
		System.out.println(db.insert2("seq_user", stu));
		
	}
}
