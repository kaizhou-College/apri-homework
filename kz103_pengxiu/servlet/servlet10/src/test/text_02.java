package test;

import entity.GirlFriend;
import entity.stl;

public class text_02 {
//4.写一个简单的例子，实现浅度克隆和深度克隆的例子
	public static void main(String[] args) {
		stl s = new stl();
		s.setName("a");
		s.setSec("aa");
		
		stl s2 = s;
		s2.setName("bb");
		System.out.println(s.getName());
		System.out.println(s2.getName());
		
		
	//深度
		stl ss = new stl();
		s.setName("daf");
		GirlFriend gfs = new GirlFriend();
		gfs.setName("潘大妈");
		s.setGf(gfs);
		
		stl ss2 = (stl) s.clone();
		s2.setUname("苏大妈");
		//改邓大妈的女朋友的名字
		s2.getGf().setName("康大妈222");
		System.out.println(ss.getGf().getName());
		System.out.println(ss2.getGf().getName());
	}
	
}
