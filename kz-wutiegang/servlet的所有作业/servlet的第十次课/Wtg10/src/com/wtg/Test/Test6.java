package com.wtg.Test;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.StudentInfo;

public class Test6 {
	public static void main(String[] args) {
		BaseDao b=new BaseDao();
		StudentInfo stu=new StudentInfo();
		Class c1 = stu.getClass();
		b.delete(c1, 8);
	}
}
