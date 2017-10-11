package JndiHomework;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;


public class Work1 {
	public static void main(String[] args) {
		//��һ��׼����ֽ
		Properties ps= new Properties();
		//��ʼ��װ
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			Context con=new InitialContext(ps);
			//�������bind()
			con.bind("�ز�", "��������˿");
			con.bind("ˮ��", "̩������â");
			con.bind("����", "����ǽ");
			con.bind("���", new Food("��ɭ�ֵ���",70));
			con.bind("����", "��ϰ��ϣ������������Ź�");
			//������ӣ����ݲ˵����õ��ˣ�
			/*		NamingEnumeration<NameClassPair> list = con.list("");
					while(list.hasMoreElements()){
						Object obj = list.nextElement();
						System.out.println(obj);
					}*/
			
			
			//���в鿴���ַ�ʽlookUp("")
			//һ
	/*		String shui=(String) con.lookup("ˮ��");
			System.out.println(shui);
			//��
			Food food=(Food)con.lookup("���");
			System.out.println(food);*/
			
			
			//�����Ƴ�unBind()
			con.unbind("����");
			NamingEnumeration<NameClassPair> list = con.list("");
			while(list.hasMoreElements()){
				Object obj = list.nextElement();
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
