package test;

import dao.Basedao;
import entity.StudentInfo;


public class Work1 {
	public static void main(String[] args) {
		Basedao bd=new Basedao();
		//添加
/*		StudentInfo sti=new StudentInfo();
		sti.setStunumber("009");
		sti.setStuname("黑子");
		sti.setStuage(19);
		sti.setStusex("男");
		sti.setStucard("432543199809091234");
		sti.setStujointime("09-9月-17");
		sti.setStuaddress("动漫世界");
		sti.setSclassid(5);
		System.out.println(bd.save("seq_sti", sti));*/
		//查询
/*		List list=bd.find(ClassInfo.class);
			for (Object obj : list) {
				ClassInfo cli=(ClassInfo)obj;
				System.out.println(cli);
		}*/
	}
}
