package action;

import com.opensymphony.xwork2.Action;
//第一种实现接口的方法
public class Work1_1 implements Action{

	public String execute() throws Exception {
		System.out.println("我是Work1_1的实现接口方法");
		return SUCCESS;
	}

}
