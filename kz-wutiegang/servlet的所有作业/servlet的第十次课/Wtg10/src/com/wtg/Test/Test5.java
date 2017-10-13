package com.wtg.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.wtg.entity.Child;
/**
 * //序列化：对象的状态信息转换为可以存储或传输的形式的过程
//反序列化：可以存储或传输的形式对象数据转为对象的状态信息
//前提是：要写入文件的类必须实现Serializable接口
 * @author WTG
 *
 */
public class Test5 {
	public static void main(String[] args) throws Exception {
		/*//序列化
		//1.读入到child这个文本文档中
		 OutputStream out=new FileOutputStream("child.txt");
		 //2.把文本文档包装到对象输出流中
		 ObjectOutputStream  oos=new ObjectOutputStream(out);
		 //3.new 出对象
		 Child ch=new Child();
		 //4.设置属性值
		 ch.setAge(3);
		 ch.setName("元元");
		 //5.将设好值的对象写入包装流中
		 oos.writeObject(ch);
		 //6.关流
		 oos.close();
		 out.close();
		 */
		
		//反序列化
		 //读出
		InputStream is = new FileInputStream("child.txt");
		//放入包装流中
		ObjectInputStream ois = new ObjectInputStream(is);
		//读出到对象中
		Child chi = (Child) ois.readObject();
		System.out.println(chi);
		
		ois.close();
		is.close();
	}
}
