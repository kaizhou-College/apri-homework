package struts2Test3;
//不继承  不实现
public class ActionThree {
	public String execute(){
		System.out.println("不实现不继承创建Action测试");
		return "success";
	}
}
