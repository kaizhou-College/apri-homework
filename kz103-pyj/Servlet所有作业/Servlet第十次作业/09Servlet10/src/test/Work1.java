package test;

import dao.Basedao;
import entity.StudentInfo;


public class Work1 {
	public static void main(String[] args) throws Exception{
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
		
/*		ClassInfo ci=new ClassInfo();
		ci.setClassnumber("070395");
		ci.setCleacherid(4);
		ci.setClassgrade("S2");
		System.out.println(bd.save("seq_sti", ci));*/
		
		//查询所有
/*		List list=bd.find(ClassInfo.class);
			for (Object obj : list) {
				ClassInfo cli=(ClassInfo)obj;
				System.out.println(cli);
		}*/
		
/*		List list=bd.find(StudentInfo.class);
		for (Object obj : list) {
			StudentInfo sti=(StudentInfo)obj;
			System.out.println(sti.toString());
		}*/
		
		//查单个数据
/*		StudentInfo stu=new StudentInfo();
		System.out.println(bd.load(StudentInfo.class, 8));*/
/*		
		ClassInfo cli=new ClassInfo();
		System.out.println(bd.load(ClassInfo.class, 5));*/
		
		//删除
/*		ClassInfo cli=new ClassInfo();
		System.out.println(bd.del(ClassInfo.class, 5));*/
		
/*		StudentInfo stu=new StudentInfo();
		System.out.println(bd.del(StudentInfo.class, 4));*/
		
		//软修改
/*		ClassInfo cli=new ClassInfo();
		cli.setClassid(2);
		cli.setClassnumber("07999");
		System.out.println(bd.update(cli));*/

		StudentInfo stu=new StudentInfo();
		stu.setStuid(8);
		stu.setStuname("猪八戒");
		System.out.println(bd.update(stu));
	}
}
