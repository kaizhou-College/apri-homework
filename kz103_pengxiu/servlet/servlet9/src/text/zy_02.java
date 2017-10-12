package text;

import entity.A;

public class zy_02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//及时的
		System.out.println("-----  及时的  -------");
		Class forName1 = Class.forName("entity.A");
		A a1=(A) forName1.newInstance();
		//延时的
		System.out.println("-----  延时的  -------");
		Class name1=A.class;
		A a2=(A)name1.newInstance();
		
		
		
		
	}		
}
