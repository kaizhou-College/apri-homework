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
		//事务
		session.beginTransaction();
		//1,new----瞬时态
		Users u = new Users();
		u.setUuid(42L);
		u.setUname("旺达帕5");
		u.setAge(12L);
		u.setSex("女");
		u.setSalary(9.9);
		//1,瞬时态--->持久态
		//session.save(u);
		//session.update(u);//必须提供id  否者报错
		//对象有id则执行更新，对象没有id执行添加
		//2,瞬时态----持久态
		//session.saveOrUpdate(u);
		
		//3,get  持久态
		Users u1 = (Users) session.get(Users.class, 42L);
		u1.setUname("二狗子2");
		//4,load  持久态
		Users u2 = (Users) session.load(Users.class, 46L);
		u2.setUname("三狗子2");
		session.beginTransaction().commit();
		//3,持久态----游离态
		session.close();
	}
}
