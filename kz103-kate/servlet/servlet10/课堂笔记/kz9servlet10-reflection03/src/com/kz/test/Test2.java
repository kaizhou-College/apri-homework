package com.kz.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.kz.entity.StudentInfo;

//���л��������״̬��Ϣת��Ϊ���Դ洢�������ʽ�Ĺ���
//�����л������Դ洢�������ʽ��������תΪ�����״̬��Ϣ
//ǰ���ǣ�Ҫд���ļ��������ʵ��Serializable�ӿ�
public class Test2 {
	public static void main(String[] args) throws Exception{
		/*OutputStream out = new FileOutputStream("user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		StudentInfo stu = new StudentInfo();
		stu.setStunumber("10101");
		stu.setStuname("�մ���");
		stu.setStusex("Ů");
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
