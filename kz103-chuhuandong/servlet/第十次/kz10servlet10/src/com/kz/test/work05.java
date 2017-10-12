package com.kz.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.kz.entity.student;

public class work05{
	public static void main(String[] args) throws Exception {
		//Œ‘
//		OutputStream out =new FileOutputStream("student.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(out);
//		student stu = new student();
//		stu.setAge(5);
//		stu.setName("Íõ´óÅÚ");
//		oos.writeObject(stu);
//		oos.close();
//		out.close();
		InputStream input = new FileInputStream("student.txt");
		ObjectInputStream ois = new ObjectInputStream(input);
		student stu = (student) ois.readObject();
		System.out.println(stu.getAge());
		System.out.println(stu.getName());
		ois.close();
		input.close();
	}
}
