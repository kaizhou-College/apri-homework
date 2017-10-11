package Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.A;

/*��дһ�������࣬Ҫ���ڴ����main���������A���е�����
 * ���ԣ��������η������ͣ������������������η�����������
 * �Ͳ����б���*/
public class Work1Test {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("entity.A");
			A a=(A)clazz.newInstance();
			//�õ����е�����
			Field[] f=clazz.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(Judeg(f[i].getModifiers())+"\t"+
						Types(f[i].getType())+"\t"+f[i].getName());
			}
			
			//�õ����з���
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
		//��һ��
	/*	if(modify==0){
			return" ";
		}else if(modify==1){
			return "public";
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}*/
		
		//�ڶ���
		return Modifier.toString(modify);
	}
	//��һ��
	public static String Types(Class type){
		StringBuffer red=new StringBuffer();
		String ty=type.getSimpleName();
		red.append(ty);
		return red.toString();
	}
	//�ڶ���
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
