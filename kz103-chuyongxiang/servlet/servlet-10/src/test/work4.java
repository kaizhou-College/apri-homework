package test;

import entity.JOB;
import entity.USERS;

public class work4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//ǳ�ȿ�¡
//		USERS s=new USERS();
//		s.setName("����");
//		USERS s2=new USERS();
//		s2.setName("��������");
//		System.out.println(s.getName());
//		System.out.println(s2.getName());
		
		//��ȿ�¡
		USERS user=new USERS();
		user.setName("������");
		JOB job =new JOB();
		job.setZhiwei("����");
		user.setZhiwei(job);
		USERS user2 = (USERS) user.clone();
		user2.setName("����");
		user2.getZhiwei().setZhiwei("����");
		System.out.println(user.getName());
		System.out.println(user.getZhiwei().getZhiwei());
		System.out.println(user2.getName());
		System.out.println(user2.getZhiwei().getZhiwei());
		
	}
}
