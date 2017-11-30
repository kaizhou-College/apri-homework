package test.interceper;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceper extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		//第一步：拿到session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//第二步：在session中拿值
	        String uname = (String) session.get("uname");  
	        System.out.println(uname);
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	            String tips = "请先登录用户！";  
	            session.put("tips", tips);  
	            return "input";  
	        }  
	}

}
