package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;


public class Test1 {
	public static void main(String[] args) {
		//1,��ȡ�����ļ�
		Configuration configure = new Configuration().configure(" hibernate.cfg.xml");
		//2���õ�sessionFactory
		SessionFactory sf = configure.buildSessionFactory();
		//3,�õ�session
		Session session = sf.openSession();
		//////////////////��������:��ɾ��//////////////////////////
		session.beginTransaction();
		/////////////////////////////////////////////
		//4,ɾ��
		//Users u = new Users();
		//hibernate��ͨ��������Ψһ��ʾһ������
		//u.setUuid(2);
		//session.delete(u);
		//5,����
//		Users u = new Users();
//		// Ӳ����
//		u.setUname("������22");
//		u.setUuid(3);
//		u.setAge(13);
//		u.setSalary(999.9);
//		u.setSex("��");
//		
//		session.update(u);
		
		//�����
		//1,�õ��������
		Users u = (Users) session.get(Users.class, 3);
		//2,�����
		u.setUname("������44");
		
		//////////////////�ύ����//////////////////////////
		session.beginTransaction().commit();
		/////////////////////////////////////////////
		//5,�ر�session
		session.close();
		sf.close();
		
	}
}
