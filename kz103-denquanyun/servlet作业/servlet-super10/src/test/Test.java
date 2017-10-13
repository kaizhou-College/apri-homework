package test;

import java.util.List;

import dao.BaseDao;
import entity.StudentInfo;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("entity.StudentInfo");
		StudentInfo stu = new StudentInfo();
//		stu.setStuid(66);
//		stu.setStuname("µË¿É°®");
//		int num = BaseDao.reUpdate(stu);
//		System.out.println(num);
		Object load = BaseDao.load(stu.getClass(),66);
		System.out.println(load);
	}
}
