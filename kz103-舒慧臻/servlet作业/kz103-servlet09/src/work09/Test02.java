package work09;

import work09.entity.A;

public class Test02 {
	public static void main(String[] args) throws Exception {
		//及时加载
		A a1 = new A();
		Class class1 = Class.forName("work09.entity.A");
		A a1_1 = (A) class1.newInstance();
		System.out.println("及时加载       	验证完毕----------------------");
		//延时加载(在生成一个对象之后才开始加载)
		Class class2 = A.class;
		A a2 = (A) class2.newInstance();
		
		
	}

}
