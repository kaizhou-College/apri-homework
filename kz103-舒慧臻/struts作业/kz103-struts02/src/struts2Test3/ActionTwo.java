package struts2Test3;

import com.opensymphony.xwork2.ActionSupport;

//�̳�
public class ActionTwo extends ActionSupport{
	public String execute() throws Exception {
		System.out.println("�̳д���Action����");
		return SUCCESS;
	}
}
