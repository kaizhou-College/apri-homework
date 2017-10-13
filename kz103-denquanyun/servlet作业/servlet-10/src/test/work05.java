package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import entity.Girl;


public class work05 {
	public static void main(String[] args) throws Exception {
		//5.写一个简单的实体类，实现序列化的读与写
//		OutputStream out = new FileOutputStream("coolGirl.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(out);
//		Girl g = new Girl();
//		g.setName("仙女");
//		g.setAge(18);
//		g.setSex("女");
//		oos.writeObject(g);
//		oos.close();
//		out.close();
		
		InputStream is = new FileInputStream("coolGirl.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		Girl g= (Girl) ois.readObject();
		System.out.println(g);
		ois.close();
		is.close();
	}
}
