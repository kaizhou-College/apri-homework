package text;

import entity.A;

public class zy_02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//��ʱ��
		System.out.println("-----  ��ʱ��  -------");
		Class forName1 = Class.forName("entity.A");
		A a1=(A) forName1.newInstance();
		//��ʱ��
		System.out.println("-----  ��ʱ��  -------");
		Class name1=A.class;
		A a2=(A)name1.newInstance();
		
		
		
		
	}		
}
