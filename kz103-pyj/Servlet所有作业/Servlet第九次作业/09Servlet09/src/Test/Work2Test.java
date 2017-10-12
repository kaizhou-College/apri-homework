package Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import entity.A;

/*再写一个测试类，要求在此类的main方法中生成一个A类的对象，
 * 使用反射技术将此对象中的a=6；b=10;再使用反射技术调用
 * showA及showB方法。*/
public class Work2Test {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("entity.A");
			A a=(A)clazz.newInstance();
			Field a1=clazz.getDeclaredField("a");
			a1.set(a, 6);
			
			Field a2=clazz.getDeclaredField("b");
			a2.setAccessible(true);
			a2.set(a, 10);
			
			Method showA=clazz.getDeclaredMethod("showA", null);
			showA.invoke(a, null);
			Method showB=clazz.getDeclaredMethod("showB", null);
			showB.setAccessible(true);
			showB.invoke(a, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
