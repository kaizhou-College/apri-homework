package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import entity.USERS;

public class work5 {
	public static void main(String[] args) throws Exception {
		//Ð´
		OutputStream out = new FileOutputStream("users.txt");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		USERS users=new USERS();
		users.setId(4);
		users.setName("ÄÄß¸");
		users.setPwd("123");
		oos.writeObject(users);
		oos.close();
		out.close();
		
		//¶Á
		InputStream is = new FileInputStream("users.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		USERS users2 = (USERS) ois.readObject();
		System.out.println(users2);
		ois.close();
		is.close();
	}
}
