package com.kz.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test3 {
	public static void main(String[] args) {
		//1,读取配置文件
		Configuration configure = new Configuration().configure(" hibernate.cfg.xml");
		//2，得到sessionFactory
		SessionFactory sf = configure.buildSessionFactory();
		//3,得到session
		Session session = sf.openSession();
		//4,查询单个 :及时加载
		//Users u = (Users) session.get(Users.class, 4);
		//System.out.println(u);
		//查询单个 :延时加载()使用才发sql语句
		//Users u1 = (Users)session.load(Users.class, 4);
		//System.out.println(u1);
		//4,1查询所有
		List<Users> users = session.createCriteria(Users.class).list();
		System.out.println(users);
		//4,2带条件查询 分页查询  模型查询 ........
		//5,关闭session
		session.close();
		sf.close();
	}
}
