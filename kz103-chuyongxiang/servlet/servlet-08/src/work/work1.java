package work;

import java.util.HashMap;


public class work1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//ʹ�ö���.getClass()�õ������
		HashMap hm1=new HashMap();
		Class cs=hm1.getClass();
		
		//ʹ������.class�õ������
		HashMap hm2=new HashMap();
		Class cs2=HashMap.class;
		
		//ͨ���ַ����õ������
		HashMap hm3=new HashMap();
		Class cs3=Class.forName("java.util.HashMap");
		
		//�������
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class cs4 = cl.loadClass("java.util.HashMap");
		HashMap hm4 = (HashMap) cs4.newInstance();
	}
	
}
