package work;

import java.util.HashMap;


public class work1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//使用对象.getClass()得到类对象
		HashMap hm1=new HashMap();
		Class cs=hm1.getClass();
		
		//使用类名.class得到类对象
		HashMap hm2=new HashMap();
		Class cs2=HashMap.class;
		
		//通过字符串得到类对象
		HashMap hm3=new HashMap();
		Class cs3=Class.forName("java.util.HashMap");
		
		//类加载器
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class cs4 = cl.loadClass("java.util.HashMap");
		HashMap hm4 = (HashMap) cs4.newInstance();
	}
	
}
