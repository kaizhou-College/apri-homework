package struts2Test3;

import com.opensymphony.xwork2.Action;
//ʵ�ֽӿ�
public class ActionOne implements Action{

	public String execute() throws Exception {
		System.out.println("�ӿڴ���Action����");
		return SUCCESS;
	}

}
