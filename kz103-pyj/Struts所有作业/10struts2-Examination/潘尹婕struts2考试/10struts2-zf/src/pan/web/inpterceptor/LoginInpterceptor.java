package pan.web.inpterceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import pan.entity.Tbl_user;
import pan.web.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInpterceptor extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation ai) throws Exception {
		System.out.println("进入拦截器........");
		//第一步：拿到session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//第二步：在session中拿值
	        String uname = (String) session.get("uname");  
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	            String tips = "请先登录用户！";  
	            session.put("tips", tips);  
	            return "input";  
	        }
	}
}