package work;

import java.util.HashMap;

/*1.ͨ��4�ַ�ʽ�õ�HashMap��Class����*/
public class work01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*��ʽһ����ʱ����
		Class clazz1 = Class.forName("java.util.HashMap");
		System.out.println(clazz1);*/
		
		/*����������ʱ����
		Class clazz2 = HashMap.class;
		System.out.println(clazz2);*/
		
		/*������������.getclass();
		 * HashMap map = new HashMap();
		Class clazz3 = map.getClass();
		System.out.println(clazz3);*/
		
		/*�����ģ��������
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class clazz4 = loader.loadClass("java.util.HashMap");
		System.out.println(clazz4);*/
	}
}
