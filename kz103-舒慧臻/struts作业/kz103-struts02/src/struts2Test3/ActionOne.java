package struts2Test3;

import com.opensymphony.xwork2.Action;
//实现接口
public class ActionOne implements Action{

	public String execute() throws Exception {
		System.out.println("接口创建Action测试");
		return SUCCESS;
	}

}
