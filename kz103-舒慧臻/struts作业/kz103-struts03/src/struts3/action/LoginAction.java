package struts3.action;

import struts3.dao.UsersDao;
import struts3.entity.Users1;

import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<Users1>{
	Users1 user = new Users1();
	@Override
	public Users1 getModel() {
		return user;
	}
	public String execute() {
		boolean use = false;
		UsersDao  dao = new UsersDao();
		Boolean isExite =dao.findByNp(user);
		if(isExite){
			return "success";
		}else{
			return "error";
		}
	}
	

	
	

}
