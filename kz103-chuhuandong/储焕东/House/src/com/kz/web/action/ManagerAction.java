package com.kz.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.BaseDao;
import com.kz.entity.TBL_FWLX;
import com.kz.entity.TBL_FWXX;
import com.kz.entity.TBL_JD;
import com.kz.entity.TBL_QX;
import com.kz.entity.TBL_USER;

public class ManagerAction {
	private String uname;
	private String upass;
	private int MessageNum;
	private TBL_FWXX fwxx;
	private int jdid;
	private String lxname;
	private String qname;
	private String jname;
	HttpServletRequest request = ServletActionContext.getRequest();
	public String LoginCheck(){
		BaseDao<TBL_USER> bs = new BaseDao<TBL_USER>();
		List<TBL_USER> user = bs.getUser(TBL_USER.class, uname);
		System.out.println(user);
		if(user.size()>0&&user.get(0).getUpass().equals(upass)){
			request.getSession().setAttribute("User", user);
			return "ok";
		}else{
			MessageNum=1;
			return "errormessage";
		}
	}
	public String postcon(){
		lxname = new BaseDao<TBL_FWLX>().getId(TBL_FWLX.class,fwxx.getLxid()).get(0).getFwlx();
		List<TBL_JD> list = new BaseDao<TBL_JD>().getId(TBL_JD.class, jdid);
		jname = list.get(0).getJD();
		fwxx.setJdid(jdid);
		fwxx.setFwid(fwxx.getFwid());
		qname = new BaseDao<TBL_QX>().getId(TBL_QX.class, list.get(0).getQXID()).get(0).getQx();
		request.getSession().setAttribute("fwxx", fwxx);
		return "request";
	}
	
	public String ss(){
		ServletActionContext.getRequest().getSession().setAttribute("isUpdate", false);
		return "add";
	}
	public String Add(){
		TBL_FWXX tb = new TBL_FWXX();
		TBL_FWXX fwxxs = (TBL_FWXX) request.getSession().getAttribute("fwxx");
		tb.setFwxx(fwxxs.getFwxx());
		tb.setJdid(fwxxs.getJdid());
		tb.setTitle(fwxxs.getTitle());
		tb.setZj(fwxxs.getZj());
		tb.setShi(fwxxs.getShi());
		tb.setTing(fwxxs.getTing());
		tb.setLxr(fwxxs.getLxr());
		tb.setLxid(fwxxs.getLxid());
		tb.setUuid(fwxxs.getUuid());
		tb.setTelephone(fwxxs.getTelephone());
		int insert = BaseDao.insert(tb, "FWXXDID");
		if(insert>0){
			return "insertok";
		}else{
			MessageNum=2;
			return "errormessage";
		}
	}
	public String addUser(){
		TBL_USER t = new TBL_USER();
		t.setUname(uname);
		t.setUpass(upass);
		int num = BaseDao.insert(t, "userids");
		if(num>0){
			return "insertok";
		}else{
			MessageNum=2;
			return "errormessage";
		}
	}
	public String delete(){
		int delete = BaseDao.Delete(fwxx, fwxx.getFwid());
		if(delete>0){
			return "deleteok";
		}else{
			MessageNum=3;
			return "errormessage";
		}
	}
	public String update(){
		TBL_FWXX tb = new TBL_FWXX();
		TBL_FWXX fwxxs = (TBL_FWXX) request.getSession().getAttribute("fwxx");
		tb.setFwxx(fwxxs.getFwxx());
		tb.setJdid(fwxxs.getJdid());
		tb.setTitle(fwxxs.getTitle());
		tb.setZj(fwxxs.getZj());
		tb.setShi(fwxxs.getShi());
		tb.setTing(fwxxs.getTing());
		tb.setLxr(fwxxs.getLxr());
		tb.setLxid(fwxxs.getLxid());
		tb.setUuid(fwxxs.getUuid());
		tb.setTelephone(fwxxs.getTelephone());
		System.out.println(tb+"??????");
		int update = BaseDao.Update(tb, fwxxs.getFwid());
		if(update>0){
			return "updateok";
		}else{
			MessageNum=4;
			return "errormessage";
		}
	}
	
	
	
	
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getMessageNum() {
		return MessageNum;
	}
	public void setMessageNum(int messageNum) {
		MessageNum = messageNum;
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
	public TBL_FWXX getFwxx() {
		return fwxx;
	}
	public void setFwxx(TBL_FWXX fwxx) {
		this.fwxx = fwxx;
	}
	
}
