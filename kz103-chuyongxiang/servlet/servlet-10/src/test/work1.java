package test;

import java.lang.reflect.Field;
import java.util.List;

import dao.BaseDao;
import entity.EMP;
import entity.USERS;

public class work1 {
	public static void main(String[] args) throws Exception{
		USERS u=new USERS();
		u.setId(5);
		u.setName("´ó¸ç´ó");
		u.setPwd("12");
		int save = BaseDao.save(u,"id");
		System.out.println(save);
	}
}
