package work;

import java.util.HashMap;

/*1.通过4种方式得到HashMap的Class对象*/
public class work01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*方式一：及时加载
		Class clazz1 = Class.forName("java.util.HashMap");
		System.out.println(clazz1);*/
		
		/*方法二：延时加载
		Class clazz2 = HashMap.class;
		System.out.println(clazz2);*/
		
		/*方法三：对象.getclass();
		 * HashMap map = new HashMap();
		Class clazz3 = map.getClass();
		System.out.println(clazz3);*/
		
		/*方法四：类加载器
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class clazz4 = loader.loadClass("java.util.HashMap");
		System.out.println(clazz4);*/
	}
}
