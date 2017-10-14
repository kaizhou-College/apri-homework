package test;

import entity.cloneTest01;
import entity.cloneTest02;

//4.写一个简单的例子，实现浅度克隆和深度克隆的例子
public class work04 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		//浅度克隆
		cloneTest01 c = new cloneTest01();
		c.setName("仙女");
		//深度克隆
		cloneTest02 c3 =new cloneTest02();
		c3.setSex("女");
		c.setClone(c3);
		System.out.println(c.getName());
		System.out.println(c.getClone());
		
		cloneTest01 c1 =(cloneTest01) c.clone();
		c1.setName("邓可爱");
		cloneTest02 c4 =new cloneTest02();
		c4.setSex("妖");
		c1.setClone(c4);
		System.out.println(c1.getClone());
		System.out.println(c1.getName());
	
		
	}
}
