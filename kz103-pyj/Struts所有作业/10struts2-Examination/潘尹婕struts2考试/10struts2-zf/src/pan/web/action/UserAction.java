package pan.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pan.biz.TbUserbiz;
import pan.dao.BaseDao;
import pan.entity.Tbl_fwxx;
import pan.entity.Tbl_user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private Tbl_user tbu;
	private TbUserbiz tbiz=new TbUserbiz();
	//校验
	private String uname;
	private String upass;
	//用户登陆
	public String login() {
		tbu = tbiz.findByNameAndPwd(tbu);
		//System.out.println("tbu===="+tbu);
		if (tbu != null) {
			ActionContext.getContext().getSession().put("tbu", tbu);
			return "login_success";
		} else {
			return "login_error";
		}
	}
	//注销
	public String tuichu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return"tuichu_success";
	}
	//注册
	public String reg(){
		int num = BaseDao.insert("seq_au",tbu);
		//System.out.println(tbu);
		if(num>0){
			return"reg_success";
		}else{
			return "input";
		}
		
	}

	//get/set
	public Tbl_user getTbu() {
		return tbu;
	}
	public void setTbu(Tbl_user tbu) {
		this.tbu = tbu;
	}
	public TbUserbiz getTbiz() {
		return tbiz;
	}
	public void setTbiz(TbUserbiz tbiz) {
		this.tbiz = tbiz;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
}
