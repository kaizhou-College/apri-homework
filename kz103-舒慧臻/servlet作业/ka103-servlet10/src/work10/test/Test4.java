package work10.test;

import work10.entity.Dept;
import work10.entity.UserInfo;

/**
 * 4.写一个简单的例子，实现浅度克隆和深度克隆的例子
 * @author ordinary
 *
 */
public class Test4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//淺度克隆
/*		UserInfo u1 = new UserInfo();
		u1.setFirstname("大");
		Dept d1 = new Dept();
		d1.setDname("ASD");
		u1.setDp(d1);
		
		//深度克隆
		UserInfo u2 = (UserInfo) u1.clone();
		u2.setFirstname("小");
		u2.getDp().setDname("FGH");
		System.out.println(u1.getDp().getDname());
		System.out.println(u2.getDp().getDname());*/
	}

}
