package test;

import java.lang.reflect.Field;
import java.util.List;

import dao.BaseDao;
import entity.EMP;

public class work1 {
	public static void main(String[] args) throws Exception{
		BaseDao db = new BaseDao();
		List list = db.find(EMP.class);
		for(Object obj :list){
			EMP emp = (EMP)obj;
			System.out.println(emp);
		}
		EMP u = new EMP();
		u.setEmpno(85);
		u.setEname("qwe");
		u.setJob("baoan");
		u.setMgr(78);
		u.setHiredate("14-8ÔÂ-17");
		u.setSal(456);
		u.setComm(12);
		u.setDeptno(20);
	}
}
