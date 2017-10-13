package com.kz.test;

import com.kz.entity.TeacherInfo;
import com.kz.entity.student;

public class work04 {
	public static void main(String[] args) throws CloneNotSupportedException{
		//淺度克隆
//		TeacherInfo t = new TeacherInfo();
//		t.setTeacherid(1);
//		TeacherInfo t2 = t;
//		t2.setTeacherid(2);
//		System.out.println(t.getTeacherid());
//		System.out.println(t2.getTeacherid());
		//深度克隆
		student s = new student();
		s.setAge(5);
		s.setName("網大炮");
		student s2 = (student) s.clone();
		System.out.println(s.getAge()+" "+s.getName());
		System.out.println(s2.getAge()+" "+s2.getName());
	}
}
