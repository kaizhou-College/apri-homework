package work;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class work02 {
	/*2、再写一个测试类，要求在此类的main方法中生成一个A类的对象，
	 * 使用反射技术将此对象中的a=6；b=10;再使用反射技术调用showA及showB方法。*/
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
