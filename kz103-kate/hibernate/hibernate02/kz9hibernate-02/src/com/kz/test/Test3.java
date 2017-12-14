package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test3 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
		//����
		session.beginTransaction();
		Users u = new Users();
		//u.setUuid(100L);
		u.setUname("������3");
		u.setAge(12L);
		u.setSex("Ů");
		u.setSalary(9.9);
		
		session.save(u);
		
		session.beginTransaction().commit();
		//3,�־�̬----����̬
		session.close();
		sf.close();
	}
}
