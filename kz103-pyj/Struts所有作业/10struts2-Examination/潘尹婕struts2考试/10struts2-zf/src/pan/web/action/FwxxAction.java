package pan.web.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import pan.biz.TbUserbiz;
import pan.dao.BaseDao;
import pan.dao.UserDao;
import pan.entity.FwxxSenior;
import pan.entity.FwxxView;
import pan.entity.Tbl_fwxx;
import pan.entity.Tbl_user;

public class FwxxAction {
	private int uid;
	private UserDao ud = new UserDao();
	private List list;
	private Tbl_fwxx tbfwxx;
	private List<Tbl_fwxx> tfwxx;
	//private Tbl_fwxx tf=new Tbl_fwxx();
	private TbUserbiz tubiz=new TbUserbiz();
	private FwxxView fwv;
	private FwxxSenior fs;
	//分页
	HttpServletRequest req=null;
	private int index;
	int pageIndex=1;//页
	int pageSize=2;//条
	//private int jdid;
	
	//分页
	public String list(){
		//System.out.println("进入查询....");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pages=BaseDao.getMax(pageSize, Tbl_user.class);
		//System.out.println(pages+"========");
		req.setAttribute("pages",pages);
		req.setAttribute("pageIndex", pageIndex);
		tfwxx=BaseDao.selectByPage(pageIndex,pageSize, Tbl_fwxx.class);
		return"list_success";
	}
	
	//租房网的删除
	public String del(){
		int delete=BaseDao.delete(Tbl_fwxx.class, tbfwxx.getFwid());
		if (delete>0) {
			return "del_success";
		}
		return "del_error";
	}
	//实际新增
	public String add(){
		int num=BaseDao.insert("seq_fw", tbfwxx);
		if(num>0){
			return"add_success";
		}
		return"add_error";
	}
	
	//修改//这是跳jsp
	public String editJump(){
		//修改前先根据id查到要修改的房屋信息
		tbfwxx=tubiz.findId(tbfwxx.getFwid());
		return"editJump_success";
	}
	//真实修改
	public String edit(){
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		String substring = time.toString().substring(0,time.toString().lastIndexOf(" "));
		tbfwxx.setPublishdate(substring);
		int num=tubiz.update(tbfwxx);
			if(num>0){
				return"edit_success";
			}else{
				return"edit_error";
			}
	}
	
	//管理租房信息先根据id查询
	public String queryById(){
		list= ud.findById(uid);
		return"fwxxlist_success";
	}
	//管理我的房屋信息时的分页
	public String glList(){
		//System.out.println("进入查询....");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pages=BaseDao.getMax(pageSize, Tbl_user.class);
		//System.out.println(pages+"========");
		req.setAttribute("pages",pages);
		req.setAttribute("pageIndex", pageIndex);
		tfwxx=BaseDao.selectByPage(pageIndex,pageSize, Tbl_fwxx.class);
		return"glList_success";
	}
	//get/set
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Tbl_fwxx getTbfwxx() {
		return tbfwxx;
	}
	public void setTbfwxx(Tbl_fwxx tbfwxx) {
		this.tbfwxx = tbfwxx;
	}
	public List<Tbl_fwxx> getTfwxx() {
		return tfwxx;
	}
	public void setTfwxx(List<Tbl_fwxx> tfwxx) {
		this.tfwxx = tfwxx;
	}
/*	public Tbl_fwxx getTf() {
		return tf;
	}
	public void setTf(Tbl_fwxx tf) {
		this.tf = tf;
	}*/

	public FwxxView getFwv() {
		return fwv;
	}
	public void setFwv(FwxxView fwv) {
		this.fwv = fwv;
	}
	public FwxxSenior getFs() {
		return fs;
	}
	public void setFs(FwxxSenior fs) {
		this.fs = fs;
	}
/*
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}*/
}
