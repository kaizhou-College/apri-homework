import java.util.List;

import dao.BaseDao;
import entity.StudentInfo;
import entity.TeacherInfo;


public class Test1 {
		public static void main(String[] args) throws Exception, IllegalAccessException {
			//ɾ������
			BaseDao b=new BaseDao();
			/*StudentInfo stu=new StudentInfo();
			Class c1 = stu.getClass();
			b.delete(c1, 4);*/
			
			//�޸Ĳ���
			StudentInfo stu1=new StudentInfo();
			stu1.setStuid(1);
			stu1.setStuname("����");
			stu1.setStusex("Ů");
			b.update(stu1);
		
     		//����
			/*TeacherInfo tho=new TeacherInfo();
			tho.setTeachername("����");
			tho.setTeacherid(3);
			tho.setTeachermail("1003242846@qq.com");
			tho.setTeachertel("123456789100");
			System.out.println(b.save(tho, "seq_myuser"));*/
			
			
			//��ѯ����
			/*StudentInfo stu11=new StudentInfo();
			List list=b.query(stu11.getClass());
			for (Object object : list) {
				StudentInfo tho2=(StudentInfo) object;
				System.out.println(tho2.toString());
			}*/
			
			
			
		}
}