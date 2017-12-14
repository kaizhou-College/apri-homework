package com.kz.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.kz.entity.Users;

public class Test1 {
	/*
	 * hibernate�ж��������״̬
	 * ˲ʱ̬��û������session���������ݿ⻺��û�ж�Ӧ�����ݵĶ����״̬��
	 * �־�̬������session����ͬʱ�����ݿ⻺���ж�Ӧ�����ݵĶ���״̬��
	 * ����̬��û������session�������������ݿ⻺���ж�Ӧ������
	 * 
	 * hibernate��ͨ��id��Ψһ��ʾһ������
	 * 1.new����һ������˲ʱ̬
	 * 2.�����ڳ־�̬��������ܽ������ݿ⡣
	 * 3.���ڳ־�̬�Ķ��󣬸ı������ԣ��ᷢ��update���������ݿ⡣
	 */
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
		//����
		session.beginTransaction();
		//���
		//1��new---->˲ʱ̬
		Users u = new Users();
		//u.setUuid(42L);
		u.setUname("������3");
		u.setAge(12L);
		u.setSex("Ů");
		u.setSalary(9.9);
		//2,˲ʱ̬---->�־�̬
		session.save(u);
		//��������ڳ־�̬������ı�������ֵ��
		//��commit��ʱ�����ݿ�ԱȻ�������session���Ķ��������һ��
		//�ͻ��Զ����»���Ķ�������ֵ���ᷢ��upate��䡣
		//u.setSex("��");
		//3,�־�̬---->����̬
		//��session�е�u�����߳�session����
		//session.evict(u);
		//session.clear();//���session
		//4,�־�̬---->˲ʱ̬
		//session.delete(u);//��u��������session
		
		//5,����̬--->˲ʱ̬
		//session.delete(u);
		//6,����̬--->�־�̬
		//session.update(u);
		//�־�̬����
		u.setSex("333");
		//�ύ����
		session.beginTransaction().commit();
		//3,�־�̬----����̬
		session.close();
		u.setSex("����2");
		sf.close();
	}
}
