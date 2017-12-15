package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;


public class Test1 {
	public static void main(String[] args) {
		//1,读取配置文件
		Configuration configure = new Configuration().configure(" hibernate.cfg.xml");
		//2，得到sessionFactory
		SessionFactory sf = configure.buildSessionFactory();
		//3,得到session
		Session session = sf.openSession();
		//////////////////开启事务:增删改//////////////////////////
		session.beginTransaction();
		/////////////////////////////////////////////
		//4,删除
		//Users u = new Users();
		//hibernate中通过主键来唯一标示一个对象
		//u.setUuid(2);
		//session.delete(u);
		//5,更新
//		Users u = new Users();
//		// 硬更新
//		u.setUname("王二狗22");
//		u.setUuid(3);
//		u.setAge(13);
//		u.setSalary(999.9);
//		u.setSex("男");
//		
//		session.update(u);
		
		//软更新
		//1,得到这个对象
		Users u = (Users) session.get(Users.class, 3);
		//2,软更新
		u.setUname("王二狗44");
		
		//////////////////提交事务//////////////////////////
		session.beginTransaction().commit();
		/////////////////////////////////////////////
		//5,关闭session
		session.close();
		sf.close();
		
	}
}
