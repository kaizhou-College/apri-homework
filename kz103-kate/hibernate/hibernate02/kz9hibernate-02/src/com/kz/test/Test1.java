package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test1 {
	/*
	 * hibernate中对象的三种状态
	 * 瞬时态：没有纳入session管理，在数据库缓存没有对应的数据的对象的状态。
	 * 持久态：纳入session管理，同时在数据库缓存有对应的数据的对象状态。
	 * 游离态：没有纳入session管理，但是在数据库缓存有对应的数据
	 * 
	 * hibernate是通过id来唯一标示一个对象。
	 * 1.new对象一定处于瞬时态
	 * 2.对象处于持久态，对象才能进入数据库。
	 * 3.处于持久态的对象，改变其属性，会发送update语句更新数据库。
	 */
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
		//事务
		session.beginTransaction();
		//添加
		//1，new---->瞬时态
		Users u = new Users();
		//u.setUuid(42L);
		u.setUname("旺达帕3");
		u.setAge(12L);
		u.setSex("女");
		u.setSalary(9.9);
		//2,瞬时态---->持久态
		session.save(u);
		//如果对象处于持久态，如果改变其属性值，
		//当commit的时候，数据库对比缓存区域session区的对象，如果不一致
		//就会自动更新缓存的对象属性值，会发送upate语句。
		//u.setSex("妖");
		//3,持久态---->游离态
		//将session中的u对象踢出session管理
		//session.evict(u);
		//session.clear();//清空session
		//4,持久态---->瞬时态
		//session.delete(u);//将u清除缓存和session
		
		//5,游离态--->瞬时态
		//session.delete(u);
		//6,游离态--->持久态
		//session.update(u);
		//持久态？？
		u.setSex("333");
		//提交事务
		session.beginTransaction().commit();
		//3,持久态----游离态
		session.close();
		u.setSex("人妖2");
		sf.close();
	}
}
