package test;

import entity.JOB;
import entity.USERS;

public class work4 {
	public static void main(String[] args) {
		//浅度克隆
		USERS s=new USERS();
		s.setName("大哥大");
		USERS s2=new USERS();
		s2.setName("超级大哥大");
		System.out.println(s.getName());
		System.out.println(s2.getName());
		
		//深度克隆
		USERS ss=new USERS();
		ss.setName("王中王");
		JOB job =new JOB();
		job.setName("保安");
		USERS ss2 = (USERS) s.clone();
		ss2.setName("门卫");
		System.out.println(ss.getName());
		System.out.println(ss2.getName());
	}
}
