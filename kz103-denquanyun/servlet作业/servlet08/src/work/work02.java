package work;

import entity.A;

/*
 * 
2.дһ��A�࣬������д��һ����̬�飬��֤��ʱ���غͼ�ʱ����
 * */
public class work02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//��ʱ����
		Class clazz1 = Class.forName("entity.A");
		A a = (A) clazz1.newInstance();
		System.out.println("----------------------------");
		//��ʱ����
		Class clazz2 = a.getClass();
		A a2 = (A) clazz2.newInstance();
		
	}
}
