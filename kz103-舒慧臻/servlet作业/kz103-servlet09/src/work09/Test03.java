package work09;

import work09.entity.HashTable;


public class Test03 {
	public static void main(String[] args) {
		Class c = HashTable.class;
		while(c != null){
			System.out.println(c.getName());
			c = c.getSuperclass();
		}
		
	}

}
