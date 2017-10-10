package JndiHomework;
/*ʹ��fscontext.jar,providerutil.jar��ȡ��ǰ�������Ŀ¼,
 * �ٸ���һ��Ŀ¼�����õ�һ���ļ�������
  Ȼ���ӡ����*/
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;

public class Work2 {
	public static void main(String[] args) {
		//�ȵ���
		Properties ps=new Properties();
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
		try {
			//��ȡ��ǰ���������ļ�
			Context con=new  InitialContext(ps);
			NamingEnumeration name = con.list("");
			while(name.hasMoreElements()){
				Object obj=name.next();
				System.out.println(obj);
			}
			//��ȡ�ļ�
			File file =(File)con.lookup("a.txt");
			FileReader fr=new FileReader(file);
			char[] ch=new char[1024];
			int length=fr.read(ch);
			while(length!=-1){
				System.out.println(ch);
				length=fr.read(ch);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
