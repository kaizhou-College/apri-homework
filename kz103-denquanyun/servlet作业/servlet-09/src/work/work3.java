package work;

import java.lang.reflect.Constructor;

public class work3 {
	/*再写一个测试类，使用反射技术分别调用B类的三个构造方法来造成B类的三个对象。*/
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("work.B");
		//第一个
		B b = (B) clazz.newInstance();
		//第二个
		Constructor constructor = clazz.getDeclaredConstructor(int.class);
		B b1 = (B) constructor.newInstance(1);
		//第三个
		Constructor constructor2 = clazz.getDeclaredConstructor(Integer.class);
		B b2 = (B) constructor2.newInstance(15);
	}
}
