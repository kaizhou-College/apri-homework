package Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import entity.A;

/*��дһ�������࣬Ҫ���ڴ����main����������һ��A��Ķ���
 * ʹ�÷��似�����˶����е�a=6��b=10;��ʹ�÷��似������
 * showA��showB������*/
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
