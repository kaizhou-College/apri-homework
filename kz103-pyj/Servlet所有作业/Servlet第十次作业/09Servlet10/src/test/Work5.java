package test;
/*дһ���򵥵�ʵ���࣬ʵ�����л��Ķ���д*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import entity.A;

public class Work5 {
	public static void main(String[] args) {
		try {
			//д
	/*		OutputStream out= new FileOutputStream("a.txt");
			ObjectOutputStream os=new ObjectOutputStream(out);
			A a=new A();
			a.setAname("�̼�");
			a.setAid(1);
			a.setAge(19);
			a.setSex("��");
			os.writeObject(a);
			os.close();
			out.close();
			System.out.println(a);*/
			
			//��
			InputStream in= new FileInputStream("a.txt");
			ObjectInputStream ois=new ObjectInputStream(in);
			A a =(A)ois.readObject();
			System.out.println(a.getAid());
			ois.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
