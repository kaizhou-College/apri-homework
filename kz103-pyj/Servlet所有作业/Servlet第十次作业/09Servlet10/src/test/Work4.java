package test;

import entity.Look;
import entity.StudentInfo;

public class Work4 {
	public static void main(String[] args) {
		StudentInfo stu=new StudentInfo();
		stu.setStuname("黑子");
		Look lk=new Look();
		lk.setName("时间");
		stu.setLk(lk);
		try {
			StudentInfo stui=(StudentInfo)stu.clone();
			stui.setStuname("老板");
			stui.getLk().setName("傻逼");
			System.out.println(stu.getLk().getName());
			System.out.println(stui.getLk().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
