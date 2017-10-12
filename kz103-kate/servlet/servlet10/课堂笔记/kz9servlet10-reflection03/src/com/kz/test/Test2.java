package com.kz.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.kz.entity.StudentInfo;

//序列化：对象的状态信息转换为可以存储或传输的形式的过程
//反序列化：可以存储或传输的形式对象数据转为对象的状态信息
//前提是：要写入文件的类必须实现Serializable接口
public class Test2 {
	public static void main(String[] args) throws Exception{
		/*OutputStream out = new FileOutputStream("user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		StudentInfo stu = new StudentInfo();
		stu.setStunumber("10101");
		stu.setStuname("苏大妈");
		stu.setStusex("女");
		stu.setA(1);
		stu.setB(2);
		oos.writeObject(stu);
		oos.close();
		out.close();*/
		
		InputStream is = new FileInputStream("user.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		StudentInfo stu = (StudentInfo) ois.readObject();
		System.out.println(stu);
		System.out.println(stu.getA());
		ois.close();
		is.close();
		
	}
}
