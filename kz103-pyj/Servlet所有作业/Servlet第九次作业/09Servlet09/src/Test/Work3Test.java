package Test;

import java.lang.reflect.Constructor;

import entity.B;

/*��дһ�������࣬ʹ�÷��似���ֱ����B��
 * ���������췽�������B�����������*/
public class Work3Test {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("entity.B");
			B b=(B)clazz.newInstance();
			
			Constructor constructor = clazz.getConstructor(int.class);
			B b1=(B)constructor.newInstance(795);
			//System.out.println(b1.toString());
			
			Constructor constructor1 = clazz.getConstructor(Integer.class);
			B b2=(B)constructor.newInstance(77);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
