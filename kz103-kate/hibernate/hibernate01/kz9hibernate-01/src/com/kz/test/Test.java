package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;
//jdbc:操作一次数据库----preparedStatement对象
//hibernate:操作一次数据库-一次会话
public class Test {
	public static void main(String[] args) {
		//1,读取配置文件  默认就是读取hibernate.hbm.xml
		Configuration cfg = new Configuration().configure(" hibernate.cfg.xml");
		//2,构建sessionFactory 会话工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//3,得到会话对象
		Session session = sessionFactory.openSession();
		//////////////////开启事务:增删改//////////////////////////
		session.beginTransaction();
		/////////////////////////////////////////////
		//4,添加一个对象到数据库的users表
		Users u = new Users();
		u.setUname("二狗子");
		u.setAge(13);
		u.setSalary(999.9);
		u.setSex("男");
		
		session.save(u);
		
		//////////////////提交事务//////////////////////////
		session.beginTransaction().commit();
		/////////////////////////////////////////////
		session.close();
		sessionFactory.close();
	
	}
}
