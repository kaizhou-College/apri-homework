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
		//调用dao的方法查询是否存在用户的方法  
		Boolean isExist = new UsersDao().find(user);
		//如果对就跳转
		if(isExist==true){
			return "success";
		}else{
			return "error";
		}
	}
}
