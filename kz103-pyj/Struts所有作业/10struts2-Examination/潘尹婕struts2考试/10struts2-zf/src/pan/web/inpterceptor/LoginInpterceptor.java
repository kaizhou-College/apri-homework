package pan.web.inpterceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import pan.entity.Tbl_user;
import pan.web.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInpterceptor extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation ai) throws Exception {
		System.out.println("����������........");
		//��һ�����õ�session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//�ڶ�������session����ֵ
	        String uname = (String) session.get("uname");  
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	            String tips = "���ȵ�¼�û���";  
	            session.put("tips", tips);  
	            return "input";  
	        }
	}
}