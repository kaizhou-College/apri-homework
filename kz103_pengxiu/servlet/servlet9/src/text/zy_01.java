package text;

import java.util.HashMap;

import entity.User;

public class zy_01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//方法一
		System.out.println("---------  方法一    --------");
		Class name1 = Class.forName("java.util.HashMap");
		HashMap user1=(HashMap)name1.newInstance();
		//方法二
		System.out.println("---------  方法二  --------");
		Class name2=HashMap.class;
		HashMap user2=(HashMap) name2.newInstance();
		//方法三
		System.out.println("---------  方法三  --------");
		HashMap user_1=new HashMap();
		Class name3=user_1.getClass();
		HashMap user3=(HashMap)name3.newInstance();
		//方法四
		System.out.println("---------  方法四  --------");
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class name4 = loader.loadClass("java.util.HashMap");
		HashMap user4=(HashMap)name4.newInstance();
	}
	
	
	
	
	
	
}
