package work;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class work02 {
	/*2����дһ�������࣬Ҫ���ڴ����main����������һ��A��Ķ���
	 * ʹ�÷��似�����˶����е�a=6��b=10;��ʹ�÷��似������showA��showB������*/
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("work.A");
		A a = (A) clazz.newInstance();
		Field aa = clazz.getDeclaredField("a");
		aa.set(a,6);
		Field ab = clazz.getDeclaredField("b");
		ab.setAccessible(true);
		ab.set(a,10);
		
		Method showA = clazz.getDeclaredMethod("showA",null);
		showA.invoke(a, null);
		Method showB = clazz.getDeclaredMethod("showB",null);
		showB.setAccessible(true);
		showB.invoke(a, null);
	}
}
