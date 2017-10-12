package work09;

import work09.entity.HashMap;





public class Test01 {
	public static void main(String[] args) throws Exception {
		//方法一：即时加载
		HashMap hm = new HashMap();
		Class clazz = Class.forName("work09.entity.HashMap");
		HashMap hsmp = (HashMap) clazz.newInstance();
		hsmp.sayHello();
		System.out.println("---------------------------");
		//方法二：延时加载
		Class clazz1 = HashMap.class;
		HashMap hashmap = (HashMap) clazz1.newInstance();
		hashmap.sayHello();
		System.out.println("===========================");
		//方法三：
		HashMap hashmap1 = new HashMap();
		Class clazz2 = hashmap1.getClass();
		HashMap hashmap2 = (HashMap) clazz2.newInstance();
		hashmap2.sayHello();
		System.out.println("*******************************");
		//方法四：类加载器
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class clazz3 = cl.loadClass("work09.entity.HashMap");
		HashMap hashmap3 = (HashMap) clazz3.newInstance(); 
		hashmap3.sayHello();
		
		
		
	}

}
