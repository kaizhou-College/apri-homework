package com.kz.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test3 {
	public static void main(String[] args) {
		//1,��ȡ�����ļ�
		Configuration configure = new Configuration().configure(" hibernate.cfg.xml");
		//2���õ�sessionFactory
		SessionFactory sf = configure.buildSessionFactory();
		//3,�õ�session
		Session session = sf.openSession();
		//4,��ѯ���� :��ʱ����
		//Users u = (Users) session.get(Users.class, 4);
		//System.out.println(u);
		//��ѯ���� :��ʱ����()ʹ�òŷ�sql���
		//Users u1 = (Users)session.load(Users.class, 4);
		//System.out.println(u1);
		//4,1��ѯ����
		List<Users> users = session.createCriteria(Users.class).list();
		System.out.println(users);
		//4,2��������ѯ ��ҳ��ѯ  ģ�Ͳ�ѯ ........
		//5,�ر�session
		session.close();
		sf.close();
	}
}
