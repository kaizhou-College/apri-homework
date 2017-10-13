package com.wtg.Test;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.Book;
import com.wtg.entity.StudentInfo;

public class Test3 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Object load = BaseDao.load(Book.class, 1);
		Book book=(Book)load;
		Object[] obj={book.getId(),book.getName(),book.getWriter()};
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		/*Object load = BaseDao.load(StudentInfo.class, 12);
		StudentInfo stu=(StudentInfo)load;
		Object[] obj={stu.getSclassid(),stu.getStuid(),stu.getStuaddress()};
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
			
		}*/
		
		
	}
}
