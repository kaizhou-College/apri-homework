package action;

import com.opensymphony.xwork2.ModelDriven;

import dao.Basedao;
import dao.UsersDao;
import entity.Users;

public class LoginAction implements ModelDriven<Users>{
	private Users user=new Users();
	public Users getModel() {
		return user;
	}
	public String execute(){
		String username=null;
		boolean use=false;
		Basedao dao=new Basedao();
		//����dao�ķ�����ѯ�Ƿ�����û��ķ���  
		Boolean isExist = new UsersDao().find(user);
		//����Ծ���ת
		if(isExist==true){
			return "success";
		}else{
			return "error";
		}
	}
}
