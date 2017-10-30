package action;


import com.opensymphony.xwork2.ActionSupport;


//继承
public class Work1_2 extends ActionSupport{
	public String execute() throws Exception{
			System.out.println("我是Work1_2的继承方法");
			return SUCCESS;
	}

}
