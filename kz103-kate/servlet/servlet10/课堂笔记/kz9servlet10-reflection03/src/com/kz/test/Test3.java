package com.kz.test;

import com.kz.entity.GirlFriend;
import com.kz.entity.Users;

//��¡�����������ڴ��п���һ��
//ǳ�ȿ�¡��ֻ���¡����ķ��Զ�������
//��ȿ�¡�����Կ�¡������Զ�������
public class Test3 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//��ȽϿ�¡  ������õĸ���
		/*Users s = new Users();
		s.setUname("�˴���");
		
		Users s2 = s;
		s2.setUname("�մ���");
		System.out.println(s.getUname());
		System.out.println(s2.getUname());*/
		//ǳ�ȿ�¡
		Users s = new Users();
		s.setUname("�˴���");
		GirlFriend gfs = new GirlFriend();
		gfs.setName("�˴���");
		s.setGf(gfs);
		
		Users s2 = (Users) s.clone();
		s2.setUname("�մ���");
		//�ĵ˴����Ů���ѵ�����
		s2.getGf().setName("������222");
		System.out.println(s.getGf().getName());
		System.out.println(s2.getGf().getName());
	}
}
