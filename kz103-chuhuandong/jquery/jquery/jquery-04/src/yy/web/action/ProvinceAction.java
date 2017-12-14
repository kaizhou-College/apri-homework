package yy.web.action;

import java.util.List;

import yy.biz.ProvinceBiz;

import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport{
	ProvinceBiz pb = new ProvinceBiz();
	private List plist;
	private List clist;
	private Integer pid;
	private Integer cid;
	private List dlist;
	public String All(){
		plist = pb.queryAll();
		return "query_success";
	}
	public String queryByPid(){
		clist = pb.queryById(pid);
		return "byid_success";
	}
	public String queryByCid(){
		dlist = pb.queryByCid(cid);
		return "bycid_success";
	}
	public List getPlist() {
		return plist;
	}
	public void setPlist(List plist) {
		this.plist = plist;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List getClist() {
		return clist;
	}
	public void setClist(List clist) {
		this.clist = clist;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public List getDlist() {
		return dlist;
	}
	public void setDlist(List dlist) {
		this.dlist = dlist;
	}
}
