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
 * 写一个简单的实体类，实现序列化的读与写
 */
public class Test5 {
		public static void main(String[] args) throws Exception {
			//1.序列化的写入文件
			/*OutputStream out = new FileOutputStream("System.txt");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			StudentInfo stu = new StudentInfo();
			stu.setStunumber("1003242846");
			stu.setStuname("Admin初梦");
			stu.setStusex("男");
			oos.writeObject(stu);
			oos.close();
			out.close();*/
			
			//2.序列化的读取文件
			InputStream is = new FileInputStream("System.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			StudentInfo stu = (StudentInfo) ois.readObject();
			System.out.println(stu);
			ois.close();
			is.close();
		}
}
