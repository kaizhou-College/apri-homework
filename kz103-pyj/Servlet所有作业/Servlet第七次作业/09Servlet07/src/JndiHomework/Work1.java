package JndiHomework;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;


public class Work1 {
	public static void main(String[] args) {
		//第一步准备好纸
		Properties ps= new Properties();
		//开始包装
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			Context con=new InitialContext(ps);
			//进行添加bind()
			con.bind("素菜", "醋溜土豆丝");
			con.bind("水果", "泰国大香芒");
			con.bind("主菜", "佛跳墙");
			con.bind("甜点", new Food("黑森林蛋糕",70));
			con.bind("凉菜", "苦瓜拌苦瓜，苦苦更健康，才怪");
			//测试添加（根据菜单名得到菜）
			/*		NamingEnumeration<NameClassPair> list = con.list("");
					while(list.hasMoreElements()){
						Object obj = list.nextElement();
						System.out.println(obj);
					}*/
			
			
			//进行查看两种方式lookUp("")
			//一
	/*		String shui=(String) con.lookup("水果");
			System.out.println(shui);
			//二
			Food food=(Food)con.lookup("甜点");
			System.out.println(food);*/
			
			
			//进行移除unBind()
			con.unbind("凉菜");
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
