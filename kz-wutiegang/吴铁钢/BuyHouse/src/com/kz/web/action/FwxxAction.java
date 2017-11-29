package com.kz.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kz.biz.FwxxBiz;
import com.kz.entity.QueryFwxx;
import com.kz.entity.Tbl_fwxx;
import com.kz.entity.Tbl_user;
import com.opensymphony.xwork2.ActionSupport;

public class FwxxAction extends ActionSupport{
	private List<Tbl_fwxx> fwxx;
	private Tbl_user user=new Tbl_user();
	private Object uname ;
	private Object uid;
	private FwxxBiz fwxxbiz=new FwxxBiz();
	private int page;
	private int max;
	private Tbl_fwxx tblfwxx;
	private QueryFwxx queryfwxx;
	public String look(){
		try {
			tblfwxx=fwxxbiz.updateById(Tbl_fwxx.class,tblfwxx.getFwid());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "look_success";
	}
	//更新
	public String update(){
		try {
			int number=fwxxbiz.update(tblfwxx,tblfwxx.getFwid());
			if (number>0) {
				return "update_success";
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update_file";
	}
	//根据id查找数据
	public String updateById(){
		try {
			tblfwxx=fwxxbiz.updateById(Tbl_fwxx.class,tblfwxx.getFwid());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "updateById_success";
	}
	//新增显示
	public String add(){
		try {
			int number=fwxxbiz.add("seq_tblfwxx",tblfwxx);
			if (number>0) {
				return "add_success";
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "add_file";
	}
	public String confirm(){
		uid=fwxxbiz.findById();
		return "confirm_success";
	}
	//查询
	public String index(){
		Object uid = ServletActionContext.getRequest().getSession().getAttribute("uuid");
		if (page==0) {
			page=1;
		}
		max=fwxxbiz.MaxPage(Tbl_fwxx.class, 2,uid);
		fwxx =fwxxbiz.selByPage(Tbl_fwxx.class, page, 2,uid);
		return "index_success";
	}
	//高级查询加普通查询加分页
	public String query(){
		
		Object uid = ServletActionContext.getRequest().getSession().getAttribute("uuid");
		if (page==0) {
			page=1;
		}
		if (queryfwxx!=null) {
			max=fwxxbiz.gjMaxPage(Tbl_fwxx.class, page, 2,queryfwxx,uid);
			fwxx=fwxxbiz.findByUQSM(Tbl_fwxx.class, page, 2, queryfwxx,uid);
			return "query_success";
		}else{
			uname = fwxxbiz.findUser();
			max=fwxxbiz.MaxPage(Tbl_fwxx.class, 2,uid);
			fwxx =fwxxbiz.selByPage(Tbl_fwxx.class, page, 2,uid);
			return "query_success";
		}
		
	}
	//新增
	public String post(){
		uname = fwxxbiz.findUser();
		if (uname!=null) {
			return "post_success";	
		}
		return "post_file";
	}
	//判断是否已经登录
	public String my(){
		//如果传过来的值为空就说明用户没有登录
		Object uid = ServletActionContext.getRequest().getSession().getAttribute("uuid");
		uname = fwxxbiz.findUser();
		if (uname!=null) {
			if (page==0) {
				
				page=1;
			}
			max=fwxxbiz.MaxPage(Tbl_fwxx.class, 2,uid);
			fwxx =fwxxbiz.selByPage(Tbl_fwxx.class, page, 2,uid);
		
			return "my_success";
		}else{
			return "my_file";
		}
		
	}
	public String mypage(){
		Object uid = ServletActionContext.getRequest().getSession().getAttribute("uuid");
		if (page==0) {
			page=1;
		}
		max=fwxxbiz.MaxPage(Tbl_fwxx.class, 2,uid);
		fwxx =fwxxbiz.selByPage(Tbl_fwxx.class, page, 2,uid);
		return "mypage_success";
	}
	
	//删除
	public String delete(){
		uname = fwxxbiz.findUser();
		if (uname!=null) {
			int number=fwxxbiz.delete(Tbl_fwxx.class,tblfwxx.getFwid());
			if (number>0) {
				return "delete_success";
			}
		}
			
		return "delete_file";
	}
	public List<Tbl_fwxx> getFwxx() {
		return fwxx;
	}
	public void setFwxx(List<Tbl_fwxx> fwxx) {
		this.fwxx = fwxx;
	}
	public Tbl_user getUser() {
		return user;
	}
	public void setUser(Tbl_user user) {
		this.user = user;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public Tbl_fwxx getTblfwxx() {
		return tblfwxx;
	}
	public void setTblfwxx(Tbl_fwxx tblfwxx) {
		this.tblfwxx = tblfwxx;
	}
	public QueryFwxx getQueryfwxx() {
		return queryfwxx;
	}
	public void setQueryfwxx(QueryFwxx queryfwxx) {
		this.queryfwxx = queryfwxx;
	}
	public Object getUname() {
		return uname;
	}
	public void setUname(Object uname) {
		this.uname = uname;
	}
	public Object getUid() {
		return uid;
	}
	public void setUid(Object uid) {
		this.uid = uid;
	}
	

	
	
}
