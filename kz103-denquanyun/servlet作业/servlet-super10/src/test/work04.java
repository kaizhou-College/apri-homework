package test;

import entity.cloneTest01;
import entity.cloneTest02;

//4.дһ���򵥵����ӣ�ʵ��ǳ�ȿ�¡����ȿ�¡������
public class work04 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		//ǳ�ȿ�¡
		cloneTest01 c = new cloneTest01();
		c.setName("��Ů");
		//��ȿ�¡
		cloneTest02 c3 =new cloneTest02();
		c3.setSex("Ů");
		c.setClone(c3);
		System.out.println(c.getName());
		System.out.println(c.getClone());
		
		cloneTest01 c1 =(cloneTest01) c.clone();
		c1.setName("�˿ɰ�");
		cloneTest02 c4 =new cloneTest02();
		c4.setSex("��");
		c1.setClone(c4);
		System.out.println(c1.getClone());
		System.out.println(c1.getName());
	
		
	}
}
