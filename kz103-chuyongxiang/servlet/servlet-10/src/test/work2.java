package test;

import java.util.List;

import dao.BaseDao;
import entity.EMP;

public class work2 {
	public static void main(String[] args) {
		System.out.println(BaseDao.find(EMP.class));
		List<Object> list = BaseDao.find(EMP.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
