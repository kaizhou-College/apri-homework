package test;

import java.util.List;

import dao.BaseDao;
import entity.StudentInfo;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("entity.StudentInfo");
		StudentInfo stu = new StudentInfo(66,"110","��Ů",18,"Ů","431101199902140087","15-9��-17","�˼��ɾ�",8);
		List load = BaseDao.load(clazz,4);
		for (int i = 0; i < load.size(); i++) {
			System.out.println(load.get(i));
		}
	}
}
