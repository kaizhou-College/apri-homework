package test;

import entity.Look;
import entity.StudentInfo;

public class Work4 {
	public static void main(String[] args) {
		StudentInfo stu=new StudentInfo();
		stu.setStuname("����");
		Look lk=new Look();
		lk.setName("ʱ��");
		stu.setLk(lk);
		try {
			StudentInfo stui=(StudentInfo)stu.clone();
			stui.setStuname("�ϰ�");
			stui.getLk().setName("ɵ��");
			System.out.println(stu.getLk().getName());
			System.out.println(stui.getLk().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
