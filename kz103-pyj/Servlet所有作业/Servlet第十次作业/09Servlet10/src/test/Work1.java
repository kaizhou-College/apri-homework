package test;

import dao.Basedao;
import entity.StudentInfo;


public class Work1 {
	public static void main(String[] args) throws Exception{
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
		
/*		ClassInfo ci=new ClassInfo();
		ci.setClassnumber("070395");
		ci.setCleacherid(4);
		ci.setClassgrade("S2");
		System.out.println(bd.save("seq_sti", ci));*/
		
		//��ѯ����
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
		
		//�鵥������
/*		StudentInfo stu=new StudentInfo();
		System.out.println(bd.load(StudentInfo.class, 8));*/
/*		
		ClassInfo cli=new ClassInfo();
		System.out.println(bd.load(ClassInfo.class, 5));*/
		
		//ɾ��
/*		ClassInfo cli=new ClassInfo();
		System.out.println(bd.del(ClassInfo.class, 5));*/
		
/*		StudentInfo stu=new StudentInfo();
		System.out.println(bd.del(StudentInfo.class, 4));*/
		
		//���޸�
/*		ClassInfo cli=new ClassInfo();
		cli.setClassid(2);
		cli.setClassnumber("07999");
		System.out.println(bd.update(cli));*/

		StudentInfo stu=new StudentInfo();
		stu.setStuid(8);
		stu.setStuname("��˽�");
		System.out.println(bd.update(stu));
	}
}
