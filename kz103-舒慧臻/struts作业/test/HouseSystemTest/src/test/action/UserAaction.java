package test.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import test.dao.BaseDao;
import test.dao.FwxxDao;
import test.dao.JdDao;
import test.dao.UserDao;
import test.entity.FwxxAndFwlx;
import test.entity.FwxxDim;
import test.entity.FwxxView;
import test.entity.JdAndQx;
import test.entity.Tbl_Fwlx;
import test.entity.Tbl_Fwxx;
import test.entity.Tbl_Jd;
import test.entity.Tbl_Qx;
import test.entity.Tbl_User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAaction extends ActionSupport{
	private Tbl_User user ;
	private List<Tbl_Fwxx> info;
	private Tbl_Fwxx xx;//房屋信息
	private Tbl_Jd jd;//街道
	private List<Tbl_Jd> jds;
	private Tbl_Qx qx;//区县
	private List<Tbl_Fwlx> lxs;//类型集合
	private List<Tbl_Qx> qxs;//区县集合
	private Tbl_Fwlx lx;//类型
	private List<FwxxAndFwlx> ff;//房屋信息和房屋类型
	private List<JdAndQx> jq;//街道和区县
	private FwxxView fv;
	private FwxxDim fd;
	private List<FwxxDim> list;
	private UserDao udao = new UserDao();
	private BaseDao dao = new BaseDao();
	private FwxxDao fdao = new FwxxDao(); 
	private JdDao jdao = new JdDao();
	private String upass1;//重复登录的密码
	private int userid;
	private int fwxxid;//房屋信息ID
	private int fwid;
	private int jdid;
	private int page = 1;//页数
	private int pageSize =3;
	private int max;//最大页
	public String denglu(){
		//得到jsp页面的用户名及密码并保存在session里
		System.out.println("进入登录页面");
		user = udao.queryNameAndPwdza(user);
		if(user!=null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			return "login_success";
		}else{
			return "input";
		}
	}
	//注销
	public String zhuxiao(){
		System.out.println("进入注销页面");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "login";
	}
	//转去首页(待完善……)
	public String list(){
		info = dao.selectByPage(pageSize, page,Tbl_Fwxx.class);
		max = dao.getMax(Tbl_Fwxx.class,pageSize);
		if(page==0){
			page = 1;
		}
		if(max==0){
			max = 1;
		}
		return "index";
	}
	//注册用户
	public String zhuce(){
		System.out.println("进入注册页面");
		int num = dao.insert("seq_user",user);
		System.out.println(upass1+"=======");
		if(num>0&&user.getUpass().equals(upass1)){
			return "index";
		}else{
			return "zhuce_filed";
		}
	}
	//分页查询
	public String currentPage(){
		System.out.println("进入分页查询");
		info = dao.selectByPage(pageSize, page,Tbl_Fwxx.class);
		max = dao.getMax(Tbl_Fwxx.class,pageSize);
		if(page==0){
			page = 1;
		}
		if(max==0){
			max = 1;
		}
		return "current_success";
	}
	//管理页面
	public String guanli(){
		System.out.println("进入管理页面");
		info = fdao.queryById(Tbl_Fwxx.class, userid);
		System.out.println("======="+info);
		System.out.println(userid);
		ServletActionContext.getRequest().getSession().setAttribute("userid", userid);
		user = (Tbl_User) udao.queryById(Tbl_User.class, userid);
		return "guanli_success";
	}
	
	//删除（根据房屋信息ID来删除）
	public String del(){
		System.out.println("进入删除操作");
		int num = dao.delete(Tbl_Fwxx.class, fwxxid);
		System.out.println("fwxx========"+fwxxid);
		if(num>0){
			return "del_success";
		}else{
			return "del_filed";
		}
	}
	//删除之后的管理
	public String reguanli(){
		System.out.println("进入删除之后的管理页面");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object attribute = session.getAttribute("userid");
//		System.out.println(attribute);
		info = dao.ReQueryById(Tbl_Fwxx.class, attribute);
//		System.out.println("======="+info);
//		System.out.println(userid);
		user = (Tbl_User) udao.ReQueryById(Tbl_User.class, attribute);
		return "guanli_success";
	}
	//进入修改
	public String enterupdate(){
		System.out.println("进入修改");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object attribute = session.getAttribute("userid");
		xx = (Tbl_Fwxx) dao.queryById(Tbl_Fwxx.class, fwxxid);
		System.out.println(xx);
		return "enter_update";
	}
	//修改操作
	public String update(){
		System.out.println("进入修改操作");
		System.out.println(xx);
		int userid = fdao.queryById(xx.getFwid());
		user = (Tbl_User) udao.queryById(Tbl_User.class, userid);
		System.out.println(user);
		System.out.println(userid);
		xx.setFwxx(xx.getFwxx());
		xx.setUuid(xx.getUuid());
		xx.setJdid(xx.getJdid());
		xx.setLxid(xx.getLxid());
		xx.setLxr(xx.getLxr());
		xx.setPublishdate(xx.getPublishdate());
		xx.setShi(xx.getShi());
		xx.setTelephone(xx.getTelephone());
		xx.setTing(xx.getTing());
		xx.setTitle(xx.getTitle());
		xx.setZj(xx.getZj());
		xx.setFwid(xx.getFwid());
		System.out.println(xx.getFwid());
		int num = dao.update(xx);
		System.out.println(xx.getFwid());
		if(num>0){
			return "update_success";
		}else{
			return "update_filed";
		}
	}
	//发布
	public String add(){
		System.out.println("进入发布页面");
		xx.setFwxx(xx.getFwxx());
		xx.setUuid(xx.getUuid());
		xx.setJdid(xx.getJdid());
		xx.setLxid(xx.getLxid());
		xx.setLxr(xx.getLxr());
		xx.setPublishdate(xx.getPublishdate());
		xx.setShi(xx.getShi());
		xx.setTelephone(xx.getTelephone());
		xx.setTing(xx.getTing());
		xx.setTitle(xx.getTitle());
		xx.setZj(xx.getZj());
		int num = dao.insert("seq_user", xx);
		if(num>0){
			return "add_success";
		}else{
			return "add_filed";
		}
	}
	//详情
	public String find(){
		System.out.println("进入详情");
		System.out.println(fwid);
		int userid = fdao.queryById(fwid);
		user = (Tbl_User) udao.queryById(Tbl_User.class, userid);
		xx = (Tbl_Fwxx) dao.queryById(Tbl_Fwxx.class, fwid);
		int lxid = xx.getLxid();
		lx = (Tbl_Fwlx) udao.queryById(Tbl_Fwlx.class, lxid);
		return "find_success";
	}
	//高级查询
	public String hightQuery(){
		if(fd==null||(fd.getEndzj()==null&&fd.getEndzj()==null&&fd.getShi()==null&&fd.getTing()==null&&fd.getJdid()==null&&fd.getTitle().length()==0&&fd.getTime()==null)){
			if(page==0){
				page=1;
			}
			pageSize = 1;
			list = dao.selectByPage(page, pageSize, FwxxDim.class);
			max=dao.getMax(Tbl_Fwxx.class, pageSize);
			return "gaoji_success";
		}else{
			if(page==0){
				page=1;
			}
			list = fdao.queryByDim(fd,page,pageSize);
			int index = fdao.getCount(fd);
			max = dao.getMax(FwxxDim.class,index);
			return "gaoji_success";
		}
	}
	public Tbl_User getUser() {
		return user;
	}
	public void setUser(Tbl_User user) {
		this.user = user;
	}
	
	public Tbl_Fwxx getXx() {
		return xx;
	}
	public void setXx(Tbl_Fwxx xx) {
		this.xx = xx;
	}
	
	public List<Tbl_Fwlx> getLxs() {
		return lxs;
	}
	public void setLxs(List<Tbl_Fwlx> lxs) {
		this.lxs = lxs;
	}
	public Tbl_Jd getJd() {
		return jd;
	}
	public void setJd(Tbl_Jd jd) {
		this.jd = jd;
	}
	
	public FwxxView getFv() {
		return fv;
	}
	public void setFv(FwxxView fv) {
		this.fv = fv;
	}
	public Tbl_Qx getQx() {
		return qx;
	}
	public void setQx(Tbl_Qx qx) {
		this.qx = qx;
	}
	public Tbl_Fwlx getLx() {
		return lx;
	}
	public void setLx(Tbl_Fwlx lx) {
		this.lx = lx;
	}
	
	public FwxxDim getFd() {
		return fd;
	}
	public void setFd(FwxxDim fd) {
		this.fd = fd;
	}
	public List<Tbl_Fwxx> getInfo() {
		return info;
	}

	public List<FwxxAndFwlx> getFf() {
		return ff;
	}
	public void setFf(List<FwxxAndFwlx> ff) {
		this.ff = ff;
	}

	public List<JdAndQx> getJq() {
		return jq;
	}
	public void setJq(List<JdAndQx> jq) {
		this.jq = jq;
	}
	public void setInfo(List<Tbl_Fwxx> info) {
		this.info = info;
	}
	
	public List<Tbl_Jd> getJds() {
		return jds;
	}
	public void setJds(List<Tbl_Jd> jds) {
		this.jds = jds;
	}
	
	public List<Tbl_Qx> getQxs() {
		return qxs;
	}
	public void setQxs(List<Tbl_Qx> qxs) {
		this.qxs = qxs;
	}
	public String getUpass1() {
		return upass1;
	}
	public void setUpass1(String upass1) {
		this.upass1 = upass1;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getFwxxid() {
		return fwxxid;
	}
	public void setFwxxid(int fwxxid) {
		this.fwxxid = fwxxid;
	}
	
	public int getFwid() {
		return fwid;
	}
	public void setFwid(int fwid) {
		this.fwid = fwid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	

}
