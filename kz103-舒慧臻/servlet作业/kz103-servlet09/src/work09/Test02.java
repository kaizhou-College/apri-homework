package work09;

import work09.entity.A;

public class Test02 {
	public static void main(String[] args) throws Exception {
		//��ʱ����
		A a1 = new A();
		Class class1 = Class.forName("work09.entity.A");
		A a1_1 = (A) class1.newInstance();
		System.out.println("��ʱ����       	��֤���----------------------");
		//��ʱ����(������һ������֮��ſ�ʼ����)
		Class class2 = A.class;
		A a2 = (A) class2.newInstance();
		
		
	}

}
