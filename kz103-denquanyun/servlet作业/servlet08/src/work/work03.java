package work;

import java.util.Hashtable;

//3.�õ�HashTable�����и���
public class work03 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Hashtable.class;
		while(clazz1!=null){
			System.out.println(clazz1.getName());
			clazz1 = clazz1.getSuperclass();
		}
		
	}
}
