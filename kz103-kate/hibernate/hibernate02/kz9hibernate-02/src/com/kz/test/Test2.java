package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test2 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
		//����
		session.beginTransaction();
		//1,new----˲ʱ̬
		Users u = new Users();
		u.setUuid(42L);
		u.setUname("������5");
		u.setAge(12L);
		u.setSex("Ů");
		u.setSalary(9.9);
		//1,˲ʱ̬--->�־�̬
		//session.save(u);
		//session.update(u);//�����ṩid  ���߱���
		//������id��ִ�и��£�����û��idִ�����
		//2,˲ʱ̬----�־�̬
		//session.saveOrUpdate(u);
		
		//3,get  �־�̬
		Users u1 = (Users) session.get(Users.class, 42L);
		u1.setUname("������2");
		//4,load  �־�̬
		Users u2 = (Users) session.load(Users.class, 46L);
		u2.setUname("������2");
		session.beginTransaction().commit();
		//3,�־�̬----����̬
		session.close();
	}
}
