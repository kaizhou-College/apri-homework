package test;

import entity.JOB;
import entity.USERS;

public class work4 {
	public static void main(String[] args) {
		//ǳ�ȿ�¡
		USERS s=new USERS();
		s.setName("����");
		USERS s2=new USERS();
		s2.setName("��������");
		System.out.println(s.getName());
		System.out.println(s2.getName());
		
		//��ȿ�¡
		USERS ss=new USERS();
		ss.setName("������");
		JOB job =new JOB();
		job.setName("����");
		USERS ss2 = (USERS) s.clone();
		ss2.setName("����");
		System.out.println(ss.getName());
		System.out.println(ss2.getName());
	}
}
