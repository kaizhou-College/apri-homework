package work;

import entity.A;

public class work2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//��ʱ����
		Class clazz1 = Class.forName("entity.A");
		A a = (A) clazz1.newInstance();
		//��ʱ����
		Class clazz2 = a.getClass();
		A a2 = (A) clazz2.newInstance();
		
	}
}
