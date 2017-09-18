package com.kz.sington;
//ÀÁººÊ½
/*public class Student {
	private static Student stu = null;
	private Student(){
	}
	public static Student getStudent(){
		if(stu==null){
			stu= new Student();
		}
		return stu;
	}
}*/
public class Student {
	private static Student stu = new Student();
	private Student(){
	}
	public static Student getStudent(){
		return stu;
	}
}
