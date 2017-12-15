package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;
//jdbc:����һ�����ݿ�----preparedStatement����
//hibernate:����һ�����ݿ�-һ�λỰ
public class Test {
	public static void main(String[] args) {
		//1,��ȡ�����ļ�  Ĭ�Ͼ��Ƕ�ȡhibernate.hbm.xml
		Configuration cfg = new Configuration().configure(" hibernate.cfg.xml");
		//2,����sessionFactory �Ự����
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//3,�õ��Ự����
		Session session = sessionFactory.openSession();
		//////////////////��������:��ɾ��//////////////////////////
		session.beginTransaction();
		/////////////////////////////////////////////
		//4,���һ���������ݿ��users��
		Users u = new Users();
		u.setUname("������");
		u.setAge(13);
		u.setSalary(999.9);
		u.setSex("��");
		
		session.save(u);
		
		//////////////////�ύ����//////////////////////////
		session.beginTransaction().commit();
		/////////////////////////////////////////////
		session.close();
		sessionFactory.close();
	
	}
}
