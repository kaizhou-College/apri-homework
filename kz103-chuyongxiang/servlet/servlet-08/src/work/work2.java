package work;

import entity.A;

public class work2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//即时加载
		Class clazz1 = Class.forName("entity.A");
		A a = (A) clazz1.newInstance();
		//延时加载
		Class clazz2 = a.getClass();
		A a2 = (A) clazz2.newInstance();
		
	}
}
