package Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.A;

/*再写一个测试类，要求在此类的main方法中输出A类中的所有
 * 属性（包括修饰符及类型），及方法（包括修饰符及返回类型
 * 和参数列表）。*/
public class Work1Test {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("entity.A");
			A a=(A)clazz.newInstance();
			//拿到所有的属性
			Field[] f=clazz.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(Judeg(f[i].getModifiers())+"\t"+
						Types(f[i].getType())+"\t"+f[i].getName());
			}
			
			//拿到所有方法
			Method[] m=clazz.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(Judeg(m[i].getModifiers())+"\t"+
						Types(m[i].getReturnType())+"\t"+
						m[i].getName()+"("+getTypes(m[i].getParameterTypes())+")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String Judeg(int modify){
		//第一问
	/*	if(modify==0){
			return" ";
		}else if(modify==1){
			return "public";
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}*/
		
		//第二问
		return Modifier.toString(modify);
	}
	//第一问
	public static String Types(Class type){
		StringBuffer red=new StringBuffer();
		String ty=type.getSimpleName();
		red.append(ty);
		return red.toString();
	}
	//第二问
	public static String getTypes(Class[] cl){
		StringBuffer red2=new StringBuffer();
		for (int i = 0; i < cl.length; i++) {
			red2.append(cl[i].getSimpleName());
			if(i!=cl.length-1){
				red2.append(",");
			}
		}
		return red2.toString();
	}
}
