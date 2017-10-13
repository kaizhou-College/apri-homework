package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import entity.stl;

public class text_03 {
	
	//5.写一个简单的实体类，实现序列化的读与写
	
	public static void main(String[] args) throws Exception {
//		OutputStream out=new FileOutputStream("use.txt");
//		ObjectOutputStream oos=new ObjectOutputStream(out);
//		stl a=new stl();
//		a.setName("a");
//		a.setSec("s");
//		oos.writeObject(a);
//		oos.close();
//		out.close();
		InputStream is = new FileInputStream("use.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		stl stl = (stl) ois.readObject();
		System.out.println(stl);
		ois.close();
		is.close();
//		
	}
}
