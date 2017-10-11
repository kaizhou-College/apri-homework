package work;

import java.util.Hashtable;

public class work3 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Hashtable.class;
		while(clazz1!=null){
			System.out.println(clazz1.getName());
			clazz1 = clazz1.getSuperclass();
		}
		
	}
}
