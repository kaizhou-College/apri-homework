package test.interceper;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceper extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		//��һ�����õ�session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//�ڶ�������session����ֵ
	        String uname = (String) session.get("uname");  
	        System.out.println(uname);
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	            String tips = "���ȵ�¼�û���";  
	            session.put("tips", tips);  
	            return "input";  
	        }  
	}

}
