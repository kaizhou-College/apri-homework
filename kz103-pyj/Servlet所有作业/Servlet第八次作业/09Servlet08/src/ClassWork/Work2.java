package ClassWork;

import entity.A;

//.дһ��A�࣬������д��һ����̬�飬��֤��ʱ���غͼ�ʱ����
public class Work2 {
	public static void main(String[] args) {
		try {
			//��ʱ����
			Class clazz = Class.forName("entity.A");
			A al = (A)clazz.newInstance();
			System.out.println("�ָ���===================");
			//�ӳټ���
			Class clazz2=al.getClass();
			A al2=(A)clazz2.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
