import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import entity.StudentInfo;

/**
 * 
 * @author 
 * дһ���򵥵�ʵ���࣬ʵ�����л��Ķ���д
 */
public class Test5 {
		public static void main(String[] args) throws Exception {
			//1.���л���д���ļ�
			/*OutputStream out = new FileOutputStream("System.txt");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			StudentInfo stu = new StudentInfo();
			stu.setStunumber("1003242846");
			stu.setStuname("Admin����");
			stu.setStusex("��");
			oos.writeObject(stu);
			oos.close();
			out.close();*/
			
			//2.���л��Ķ�ȡ�ļ�
			InputStream is = new FileInputStream("System.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			StudentInfo stu = (StudentInfo) ois.readObject();
			System.out.println(stu);
			ois.close();
			is.close();
		}
}
