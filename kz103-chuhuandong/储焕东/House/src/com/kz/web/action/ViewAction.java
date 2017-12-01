package com.kz.web.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.BaseDao;
import com.kz.dao.FwxxDao;
import com.kz.entity.FwxxDim;
import com.kz.entity.TBL_FWXX;
import com.kz.entity.TBL_JD;
import com.kz.entity.TBL_QX;

public class ViewAction {
	private List<TBL_FWXX> list;
	private TBL_FWXX fwxx;
	private int qxid;
	private int jdid;
	private int zj1;
	private int zj;
	private String title;
	private int fwlx;
	private FwxxDim fd;
	private boolean isUpdate = false;
	BaseDao<TBL_FWXX> bs = new BaseDao<TBL_FWXX>();
	public String showAll(){
		list = bs.SelAll(TBL_FWXX.class);
		return "show";
	}
	public String cx(){
		list = bs.SelAll(TBL_FWXX.class);
		return "shows";
	}
	public String updateView(){
		isUpdate = true;
		ServletActionContext.getRequest().getSession().setAttribute("isUpdate", isUpdate);
		list = bs.getId(TBL_FWXX.class, fwxx.getFwid());
		List<TBL_JD> listt = new BaseDao<TBL_JD>().getId(TBL_JD.class,list.get(0).getJdid());
		qxid = listt.get(0).getQXID();
		fwxx.setFwid(list.get(0).getFwid());
		fwxx.setTitle(list.get(0).getTitle());
		fwxx.setJdid(list.get(0).getJdid());
		fwxx.setLxid(list.get(0).getLxid());
		fwxx.setLxr(list.get(0).getLxr());
		fwxx.setPublishdate(list.get(0).getPublishdate());
		fwxx.setShi(list.get(0).getShi());
		fwxx.setTing(list.get(0).getTing());
		fwxx.setTelephone(list.get(0).getTelephone());
		fwxx.setUuid(list.get(0).getUuid());
		fwxx.setZj(list.get(0).getZj());
		fwxx.setFwxx(list.get(0).getFwxx());
		return "updateshow";
	}
	public String Qeury(){
		fd = new FwxxDim();
		fd.setEndzj(zj1);
		fd.setStartzj(zj);
		fd.setJdid(jdid);
		fd.setQxid(qxid);
		fd.setShi(fwxx.getShi());
		fd.setTing(fwxx.getTing());
		fd.setTitle(title);
		System.out.println(fd.getTitle());
		fd.setLxid(fwlx);
		list = new FwxxDao<TBL_FWXX>().queryByDim(fd, 1, 5);
		return "list";
	}
	
	
	
	public int getFwlx() {
		return fwlx;
	}
	public void setFwlx(int fwlx) {
		this.fwlx = fwlx;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getZj() {
		return zj;
	}
	public void setZj(int zj) {
		this.zj = zj;
	}
	public FwxxDim getFd() {
		return fd;
	}
	public void setFd(FwxxDim fd) {
		this.fd = fd;
	}
	public int getZj1() {
		return zj1;
	}
	public void setZj1(int zj1) {
		this.zj1 = zj1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isUpdate() {
		return isUpdate;
	}
	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public TBL_FWXX getFwxx() {
		return fwxx;
	}
	public void setFwxx(TBL_FWXX fwxx) {
		this.fwxx = fwxx;
	}
	public List<TBL_FWXX> getList() {
		return list;
	}
	public void setList(List<TBL_FWXX> list) {
		this.list = list;
	}
}
