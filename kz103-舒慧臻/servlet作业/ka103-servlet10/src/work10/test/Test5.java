package work10.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import work10.entity.Dept;

/**
 * 5.写一个简单的实体类，实现序列化的读与写
 * @author ordinary
 *
 */
public class Test5 {
	public static void main(String[] args) throws Exception {
		
//		OutputStream out = new FileOutputStream("dept.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(out);
//		Dept d = new Dept();
//		d.setDeptno(124);
//		d.setDname("WRW");
//		d.setLoc("fsdgfs");
//		oos.writeObject(d);
//		oos.close();
//		out.close();
		
		
		InputStream is = new FileInputStream("dept.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		Dept dept = (Dept) ois.readObject();
		System.out.println(dept);
		System.out.println(dept.getDname());
		ois.close();
		is.close();
		
		
	}

}
