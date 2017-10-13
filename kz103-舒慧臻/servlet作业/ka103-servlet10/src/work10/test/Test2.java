package work10.test;

import java.util.List;

import work10.dao.BaseDao;
import work10.entity.Dept;
import work10.entity.UserInfo;

public class Test2 {
	public static void main(String[] args) {
		BaseDao dao = new BaseDao();
		List list = dao.find(Dept.class);
		for (Object object : list) {
			Dept uf = (Dept)object;
			System.out.println(uf);
		}
		Dept user = new Dept();
		user.setDname("ADS");
		user.setDeptno(1234);
		
	}

}
