package com.wtg.Test;

import java.util.List;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.StudentInfo;

public class Test2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		BaseDao b=new BaseDao();
		
		List list = b.find(StudentInfo.class);
		for (Object object : list) {
			StudentInfo stu=(StudentInfo)object;
			System.out.println(stu.toString());
		}
	}
}
