package web.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import dao.BaseDao;

import biz.FwxxBiz;
import entity.FwxxDim;
import entity.FwxxView;
import entity.Tbl_Fwxx;

public class FwxxAction {
	private FwxxBiz fb = new FwxxBiz();
	private int index;
	private int max;
	private final int PAGE_DEFALUT=3;
	private	Tbl_Fwxx fw;
	private List list;
	private int uid;//根据用户id查询
	private FwxxDim fd;
	public String query(){
		if(fd==null||(fd.getEndzj()==null&&fd.getEndzj()==null&&fd.getShi()==null&&fd.getTing()==null&&fd.getLxid()==null&&fd.getQxid()==null&&fd.getJdid()==null&&fd.getTitle().length()==0&&fd.getTime()==null)){
			if(index==0){
				index=1;
			}
			list = fb.query(index,PAGE_DEFALUT);
			max=fb.getMax(PAGE_DEFALUT);
			return "query_success";
		}else{
			if(index==0){
				index=1;
			}
			list = fb.queryDim(fd,index,PAGE_DEFALUT);
			max = fb.getDimMax(fd,PAGE_DEFALUT);
			return "query_success";
		}
	}
	public String indexquery(){
		if(fd==null||(fd.getEndzj()==null&&fd.getEndzj()==null&&fd.getShi()==null&&fd.getTing()==null&&fd.getLxid()==null&&fd.getQxid()==null&&fd.getJdid()==null&&fd.getTitle().length()==0&&fd.getTime()==null)){
			if(index==0){
				index=1;
			}
			list = fb.query(index,PAGE_DEFALUT);
			max=fb.getMax(PAGE_DEFALUT);
			return "indexquery_success";
		}else{
			if(index==0){
				index=1;
			}
			list = fb.queryDim(fd,index,PAGE_DEFALUT);
			max = fb.getDimMax(fd,PAGE_DEFALUT);
			return "indexquery_success";
		}
	}
	
	public String queryByUid(){
		list = fb.queryByUid(uid);
		return "queryUid_success";
	}
	public FwxxBiz getFb() {
		return fb;
	}
	public void setFb(FwxxBiz fb) {
		this.fb = fb;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public Tbl_Fwxx getFw() {
		return fw;
	}
	public void setFw(Tbl_Fwxx fw) {
		this.fw = fw;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	//房屋发布
	private int jdid;//街道id
	private int qxid;
	private FwxxView fv;
	public String add(){
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		String substring = time.toString().substring(0,time.toString().lastIndexOf(" "));
		fw.setPublishdate(substring);
		fw.setQxid(qxid);
		fw.setJdid(jdid);
		fv = fb.addView(fw);
		return "add_success";
	}
	public String addExe(){
		int num = fb.insert(fw);
		if(num>0){
			return "addExe_success";
		}else{
			return "add_error";
		}
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public FwxxView getFv() {
		return fv;
	}
	public void setFv(FwxxView fv) {
		this.fv = fv;
	}
	//房屋删除
	public String del(){
		int num = fb.del(fw.getFwid());
		if(num>0){
			return "del_success";
		}else{
			return "del_error";
		}
	}
	//跳修改页面
	public String edit(){
		fw = fb.querById(fw.getFwid());
		return "edit_success";
	}
	//跳二次确认页面
	public String update(){
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		String substring = time.toString().substring(0,time.toString().lastIndexOf(" "));
		fw.setPublishdate(substring);
		fw.setQxid(qxid);
		fw.setJdid(jdid);
		fv = fb.upView(fw);
		return "update_success";
	}
	//执行添加
	public String upExe(){
		int num = fb.edit(fw);
		if(num>0){
			return "upExe_success";
		}else{
			return "upExe_error";
		}
	}
	public FwxxDim getFd() {
		return fd;
	}
	public void setFd(FwxxDim fd) {
		this.fd = fd;
	}
	public String queryId(){
		fv=fb.queryById(fw);
		return "queryId_success";
	}
}
