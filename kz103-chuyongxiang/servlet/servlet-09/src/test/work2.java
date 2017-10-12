package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import entity.A;

public class work2 {
	public static void main(String[] args) throws Exception {
		Class forName=Class.forName("entity.A");
		A a=(A)forName.newInstance();
		Field fia =forName.getField("a");
		fia.set(a, 6);
		
		Field fib =forName.getDeclaredField("b");
		fib.setAccessible(true);
		fib.set(a, 10);
		
		Method showA = forName.getMethod("showA",null);
		showA.invoke(a, null);
		Method showB = forName.getDeclaredMethod("showB",null);
		showB.setAccessible(true);
		showB.invoke(a, null);
	}
}
