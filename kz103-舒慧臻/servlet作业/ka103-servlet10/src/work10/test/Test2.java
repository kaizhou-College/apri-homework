package work10.test;

import java.util.List;

import work10.dao.BaseDao;
import work10.entity.Dept;
import work10.entity.UserInfo;

public class Test2 {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		BaseDao dao = new BaseDao();
		/*List list = dao.find(UserInfo.class);
		for (Object object : list) {
			UserInfo uf = (UserInfo)object;
			System.out.println(uf);
		}*/
//		Dept dept = new Dept();
//		System.out.println(dao.load(Dept.class,20));
		//修改
		Dept dept = new Dept();
//		dept.setDeptno(40);
		dept.setDname("erbaobao");
		dept.setLoc("会计法开始");
		System.out.println(dao.update1(dept,10));
	}

}
