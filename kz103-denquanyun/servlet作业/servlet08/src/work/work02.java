package work;

import entity.A;

/*
 * 
2.写一个A类，在类中写好一个静态块，验证延时加载和及时加载
 * */
public class work02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//及时加载
		Class clazz1 = Class.forName("entity.A");
		A a = (A) clazz1.newInstance();
		System.out.println("----------------------------");
		//延时加载
		Class clazz2 = a.getClass();
		A a2 = (A) clazz2.newInstance();
		
	}
}
