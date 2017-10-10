package JndiHomework;
/*使用fscontext.jar,providerutil.jar读取当前类的所有目录,
 * 再根据一个目录名，得到一个文件的内容
  然后打印出来*/
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;

public class Work2 {
	public static void main(String[] args) {
		//先导包
		Properties ps=new Properties();
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
		try {
			//获取当前类下所有文件
			Context con=new  InitialContext(ps);
			NamingEnumeration name = con.list("");
			while(name.hasMoreElements()){
				Object obj=name.next();
				System.out.println(obj);
			}
			//读取文件
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
