package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.sun.net.httpserver.Authenticator.Success;

import dao.BaseDao;
import entity.Users;

public class OrderAction implements Action{
	private String name;
	private String pwd;
	private Users user = new Users();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String execute() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		HttpServletRequest req=ServletActionContext.getRequest();
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����OrderAction ִ��execute����");
		List<Users> cs=BaseDao.select(user);
		for (int i = 0; i < cs.size(); i++) {
			if(cs.get(i).getUserName().equals(name)){
				System.out.println("�û�����ȷ");
				if(cs.get(i).getUserPwd().equals(pwd)){
					System.out.println("������ȷ");
					System.out.println("��½�ɹ�");
					return "SUCCESS";
				}else{
					System.out.println("�������");
				}
			}else{
				System.out.println("�û�������");
			}
		}
		return "NO";
	}
}
