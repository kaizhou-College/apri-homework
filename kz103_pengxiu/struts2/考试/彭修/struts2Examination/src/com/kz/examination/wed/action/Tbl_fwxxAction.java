package com.kz.examination.wed.action;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kz.examination.dao.BaseDao;
import com.kz.examination.dao.TBL_FWXXDao;
import com.kz.examination.dao.TBL_JDDao;
import com.kz.examination.dao.TBL_QXDao;
import com.kz.examination.dao.TBL_USERDao;
import com.kz.examination.entity.QuXianJieDao;
import com.kz.examination.entity.QueryView;
import com.kz.examination.entity.TBL_FWLX;
import com.kz.examination.entity.TBL_FWXX;
import com.kz.examination.entity.TBL_JD;
import com.kz.examination.entity.TBL_QX;
import com.kz.examination.entity.Tbl_User;
import com.sun.org.apache.regexp.internal.recompile;

public class Tbl_fwxxAction {
	private final int PAGE_FWXX_INDEX=1;
	private final int PAGE_FWXX_SIZE=5;
	//分页的初始数据
	private int pageindex;
	//分页的每页条数
	private int pagesize;
	//分页跳转时传过来1的index数据
	private int indexces;
	//分页最大的页数
	private int pageizeZD;
	//分页查询的路径
	private String URL;
	//分页的集合
	private List<TBL_FWXX> user_list;
	//房屋信息的list
	private List<TBL_FWXX> listFwxx;
	//房屋信息的对象
	private TBL_FWXX tbl_fwxx;
	//房屋类型的对象
	private List<TBL_FWLX> listFwlx;
	//街道list
	private List<TBL_JD> jdList;
	private List<TBL_JD> jdIDList;
	//区县
	private List<TBL_QX> QxIDList;
	private List<TBL_QX> qxList;
	//街道与区的拼接
	private String jiequ;
	//区县与街道的duix
	private QuXianJieDao qxjd;
	//
	private List<TBL_QX> listQX;
	//高级查询的对象
	private QueryView qv;
	//删除的action
	//登入时获取的对象
	private Tbl_User login;
	
	//真正的添加
	public String addTbl(){
		String format=new SimpleDateFormat("dd/MM月/yyyy").format(new Date());//系统时间
		System.out.println("进来了");
		tbl_fwxx.setPublishdate(format);
		
		int insert = BaseDao.insert(tbl_fwxx);
		if(insert>0){
			return "addTbl";
		}else{
			return "error";
		}
		
	}
	//准备添加时的数据
	public String  addListTbl() {
		String format=new SimpleDateFormat("yyyy-MM-dd").format(new Date());//系统时间
		List<TBL_JD> listJDid = TBL_JDDao.listJDid(qxjd.getJieDao());
		tbl_fwxx.setJdid(listJDid.get(0).getJdid());
		tbl_fwxx.setPublishdate(format);
		tbl_fwxx.setUuid(TBL_USERDao.uname());
		//街到拼接
		TBL_JD jd=new TBL_JD();
		jd.setJdid(tbl_fwxx.getJdid());
		jiequ = TBL_FWXXDao.jiequ(jd);
		//房屋类型
		listFwlx=BaseDao.listID(new TBL_FWLX(tbl_fwxx.getLxid(),null));
		
		return "addListTbl";
	}
	//
	
	
	//n添加时我那个街道与大区的显示
	public String postJD(){
		qxList=TBL_JDDao.listQX();
		return "postJD";
	}
	
	
	public String  delteFwxx(){
//		System.out.println(tbl_fwxx.getFwid());
		int deteleTbl = BaseDao.deteleTbl(tbl_fwxx);
		if(deteleTbl>0){
			return "delteFwxx";
		}else {
			return "error";
		}
	}
	
	//真正的修改
	public String updateTbl(){
//		System.out.println("现在已经进来了");
//		System.out.println(tbl_fwxx);
		int update = BaseDao.update(tbl_fwxx);
		if(update>0){
			return "updateTBL";
		}else{
			return "error";
		}
		
	}
	
	
	//真正的修改之前条的显示页面
	public String updateListTBL(){
//		System.out.println(qxjd+"--区县街道的");
		List<TBL_JD> listJDid = TBL_JDDao.listJDid(qxjd.getJieDao());
		tbl_fwxx.setJdid(listJDid.get(0).getJdid());
//		System.out.println(tbl_fwxx.getLxid()+"---zg1jius1");
		//街到拼接
		TBL_JD jd=new TBL_JD();
		jd.setJdid(tbl_fwxx.getJdid());
		jiequ = TBL_FWXXDao.jiequ(jd);
		//房屋类型
		listFwlx=BaseDao.listID(new TBL_FWLX(tbl_fwxx.getLxid(),null));
		return "updateListTBL";
	}
	
	
	//修改的显示
	public String updateList(){
		listFwxx = BaseDao.listID(tbl_fwxx);//房屋信息
		jdList=TBL_JDDao.JdQxidLIst(listFwxx.get(0).getJdid());//街道显示
		jdIDList = BaseDao.listID(new TBL_JD(listFwxx.get(0).getJdid(),null,null));//街道默认值
		QxIDList=BaseDao.listID(new TBL_QX(jdIDList.get(0).getQxid(),null));//区县默认值
		qxList = TBL_QXDao.qxList();//区县的显示
		return "updateList";
	}
	//显示
	public String list(){
		URL="fwxx_list";
		pageindex=PAGE_FWXX_INDEX;
		if(indexces>0){
			pageindex=indexces;
		}
		pagesize=PAGE_FWXX_SIZE;
		pageizeZD=TBL_FWXXDao.advancedListCount(new QueryView(),new TBL_FWXX(), pagesize);
		user_list =TBL_FWXXDao.advancedList(new QueryView(),new TBL_FWXX(),pageindex,pagesize);
		return "list";
	}
	
	//分页查询的方法
	public String pageList(){
		URL="fwxx_pageList";
		pageindex=PAGE_FWXX_INDEX;
		if(indexces>0){
			pageindex=indexces;
		}
		pagesize=PAGE_FWXX_SIZE;
		
		System.out.println(qv);
		if(qv!=null){
			pageizeZD=TBL_FWXXDao.advancedListCount(qv,new TBL_FWXX(), pagesize);
			user_list =TBL_FWXXDao.advancedList(qv,new TBL_FWXX(),pageindex,pagesize);
		}else{
			pageizeZD=TBL_FWXXDao.advancedListCount(new QueryView(),new TBL_FWXX(), pagesize);
			user_list =TBL_FWXXDao.advancedList(new QueryView(),new TBL_FWXX(),pageindex,pagesize);
		}
		
		//高级查询需要显示的区县
		listQX = BaseDao.Select(new TBL_QX());
		return "pageList";
	}
	
	//id查询 房屋信息
	public String listDetail(){
//		System.out.println("进来了");
//		System.out.println("并且带进id了"+tbl_fwxx.getFwid());
		listFwxx=BaseDao.listID(tbl_fwxx);
		//房屋类型对象
		TBL_FWLX fwlx=new TBL_FWLX();
		fwlx.setLxid(listFwxx.get(0).getLxid());
		//街道对象
		TBL_JD jd=new TBL_JD();
		jd.setJdid(listFwxx.get(0).getJdid());
		//类型list 
		listFwlx = BaseDao.listID(fwlx);
		//街道
		jiequ = TBL_FWXXDao.jiequ(jd);
		return "listDetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<TBL_QX> getListQX() {
		return listQX;
	}
	public void setListQX(List<TBL_QX> listQX) {
		this.listQX = listQX;
	}
	public List<TBL_FWLX> getListFwlx() {
		return listFwlx;
	}

	public void setListFwlx(List<TBL_FWLX> listFwlx) {
		this.listFwlx = listFwlx;
	}

	

	public TBL_FWXX getTbl_fwxx() {
		return tbl_fwxx;
	}

	public void setTbl_fwxx(TBL_FWXX tblFwxx) {
		tbl_fwxx = tblFwxx;
	}



	public List getListFwxx() {
		return listFwxx;
	}

	public void setListFwxx(List listFwxx) {
		this.listFwxx = listFwxx;
	}

	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getIndexces() {
		return indexces;
	}
	public void setIndexces(int indexces) {
		this.indexces = indexces;
	}
	public int getPageizeZD() {
		return pageizeZD;
	}
	public void setPageizeZD(int pageizeZD) {
		this.pageizeZD = pageizeZD;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public List<TBL_FWXX> getUser_list() {
		return user_list;
	}
	public void setUser_list(List<TBL_FWXX> userList) {
		user_list = userList;
	}
	public String getJiequ() {
		return jiequ;
	}
	public void setJiequ(String jiequ) {
		this.jiequ = jiequ;
	}
	public QueryView getQv() {
		return qv;
	}
	public void setQv(QueryView qv) {
		this.qv = qv;
	}
	public List<TBL_JD> getJdList() {
		return jdList;
	}
	public void setJdList(List<TBL_JD> jdList) {
		this.jdList = jdList;
	}
	public List<TBL_JD> getJdIDList() {
		return jdIDList;
	}
	public void setJdIDList(List<TBL_JD> jdIDList) {
		this.jdIDList = jdIDList;
	}
	public List<TBL_QX> getQxIDList() {
		return QxIDList;
	}
	public void setQxIDList(List<TBL_QX> qxIDList) {
		QxIDList = qxIDList;
	}
	public List<TBL_QX> getQxList() {
		return qxList;
	}
	public void setQxList(List<TBL_QX> qxList) {
		this.qxList = qxList;
	}
	public QuXianJieDao getQxjd() {
		return qxjd;
	}
	public void setQxjd(QuXianJieDao qxjd) {
		this.qxjd = qxjd;
	}
	public Tbl_User getLogin() {
		return login;
	}
	public void setLogin(Tbl_User login) {
		this.login = login;
	}

	
}
