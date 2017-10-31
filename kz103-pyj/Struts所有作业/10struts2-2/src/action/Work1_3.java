package action;


import com.opensymphony.xwork2.ActionSupport;


//不继承也不实现
public class Work1_3 {
	public String execute(){
			System.out.println("我是Work1_3不继承也不实现的方法");
			return "success";
	}

}
