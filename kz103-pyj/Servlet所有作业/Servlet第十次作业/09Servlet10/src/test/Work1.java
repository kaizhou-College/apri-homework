package test;

import dao.Basedao;
import entity.StudentInfo;


public class Work1 {
	public static void main(String[] args) {
		Basedao bd=new Basedao();
		//���
/*		StudentInfo sti=new StudentInfo();
		sti.setStunumber("009");
		sti.setStuname("����");
		sti.setStuage(19);
		sti.setStusex("��");
		sti.setStucard("432543199809091234");
		sti.setStujointime("09-9��-17");
		sti.setStuaddress("��������");
		sti.setSclassid(5);
		System.out.println(bd.save("seq_sti", sti));*/
		//��ѯ
/*		List list=bd.find(ClassInfo.class);
			for (Object obj : list) {
				ClassInfo cli=(ClassInfo)obj;
				System.out.println(cli);
		}*/
	}
}
