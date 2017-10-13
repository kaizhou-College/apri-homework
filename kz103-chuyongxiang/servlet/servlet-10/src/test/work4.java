package test;

import entity.JOB;
import entity.USERS;

public class work4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//浅度克隆
//		USERS s=new USERS();
//		s.setName("大哥大");
//		USERS s2=new USERS();
//		s2.setName("超级大哥大");
//		System.out.println(s.getName());
//		System.out.println(s2.getName());
		
		//深度克隆
		USERS user=new USERS();
		user.setName("王中王");
		JOB job =new JOB();
		job.setZhiwei("保安");
		user.setZhiwei(job);
		USERS user2 = (USERS) user.clone();
		user2.setName("大哥大");
		user2.getZhiwei().setZhiwei("保洁");
		System.out.println(user.getName());
		System.out.println(user.getZhiwei().getZhiwei());
		System.out.println(user2.getName());
		System.out.println(user2.getZhiwei().getZhiwei());
		
	}
}
