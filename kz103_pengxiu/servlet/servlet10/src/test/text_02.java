package test;

import entity.GirlFriend;
import entity.stl;

public class text_02 {
//4.дһ���򵥵����ӣ�ʵ��ǳ�ȿ�¡����ȿ�¡������
	public static void main(String[] args) {
		stl s = new stl();
		s.setName("a");
		s.setSec("aa");
		
		stl s2 = s;
		s2.setName("bb");
		System.out.println(s.getName());
		System.out.println(s2.getName());
		
		
	//���
		stl ss = new stl();
		s.setName("daf");
		GirlFriend gfs = new GirlFriend();
		gfs.setName("�˴���");
		s.setGf(gfs);
		
		stl ss2 = (stl) s.clone();
		s2.setUname("�մ���");
		//�ĵ˴����Ů���ѵ�����
		s2.getGf().setName("������222");
		System.out.println(ss.getGf().getName());
		System.out.println(ss2.getGf().getName());
	}
	
}
