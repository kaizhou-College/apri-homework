package ClassWork;

import entity.A;

//.写一个A类，在类中写好一个静态块，验证延时加载和及时加载
public class Work2 {
	public static void main(String[] args) {
		try {
			//及时加载
			Class clazz = Class.forName("entity.A");
			A al = (A)clazz.newInstance();
			System.out.println("分割线===================");
			//延迟加载
			Class clazz2=al.getClass();
			A al2=(A)clazz2.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
