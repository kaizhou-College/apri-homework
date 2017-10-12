package com.kz.test;

import com.kz.entity.GirlFriend;
import com.kz.entity.Users;

//克隆：讲对象在内存中拷贝一份
//浅度克隆：只会克隆对象的非自定义属性
//深度克隆：可以克隆对象的自定义属性
public class Test3 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//这比较克隆  这叫引用的复制
		/*Users s = new Users();
		s.setUname("邓大妈");
		
		Users s2 = s;
		s2.setUname("苏大妈");
		System.out.println(s.getUname());
		System.out.println(s2.getUname());*/
		//浅度克隆
		Users s = new Users();
		s.setUname("邓大妈");
		GirlFriend gfs = new GirlFriend();
		gfs.setName("潘大妈");
		s.setGf(gfs);
		
		Users s2 = (Users) s.clone();
		s2.setUname("苏大妈");
		//改邓大妈的女朋友的名字
		s2.getGf().setName("康大妈222");
		System.out.println(s.getGf().getName());
		System.out.println(s2.getGf().getName());
	}
}
