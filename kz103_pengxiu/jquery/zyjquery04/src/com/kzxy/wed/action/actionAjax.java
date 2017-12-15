package com.kzxy.wed.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kzxy.dao.BaseDao;
import com.kzxy.dao.QxDao;
import com.kzxy.entity.TBL_JD;
import com.kzxy.entity.TBL_QX;
import com.kzxy.entity.TBL_SF;
import com.sun.org.apache.regexp.internal.recompile;

public class actionAjax {
	//省份
	private List<TBL_SF> sfList;
	//区县
	private List<TBL_QX> qxList;
	//街道
	private List<TBL_JD> jdList;
	//最开始省份的显示
	public String sfList(){
		sfList=new BaseDao().list(new TBL_SF());
		return "sfList";
	}
	//区县
	public String qxList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id =Integer.parseInt(request.getParameter("id"));
		qxList=new QxDao().qxList(new TBL_QX(),id);
		return "sfList";
	}
	//街道
	public String jdList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id =Integer.parseInt(request.getParameter("id"));
		jdList=new JdDao().jdList(new TBL_JD(),id);
		return "sfList";
	}
	public List<TBL_SF> getSfList() {
		return sfList;
	}
	public void setSfList(List<TBL_SF> sfList) {
		this.sfList = sfList;
	}
	public List<TBL_QX> getQxList() {
		return qxList;
	}
	public void setQxList(List<TBL_QX> qxList) {
		this.qxList = qxList;
	}
	public List<TBL_JD> getJdList() {
		return jdList;
	}
	public void setJdList(List<TBL_JD> jdList) {
		this.jdList = jdList;
	}
	
}
