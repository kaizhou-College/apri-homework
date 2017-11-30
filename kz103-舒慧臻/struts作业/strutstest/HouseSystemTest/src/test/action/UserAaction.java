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
	private Tbl_Fwxx xx;//������Ϣ
	private Tbl_Jd jd;//�ֵ�
	private List<Tbl_Jd> jds;
	private Tbl_Qx qx;//����
	private List<Tbl_Fwlx> lxs;//���ͼ���
	private List<Tbl_Qx> qxs;//���ؼ���
	private Tbl_Fwlx lx;//����
	private List<FwxxAndFwlx> ff;//������Ϣ�ͷ�������
	private List<JdAndQx> jq;//�ֵ�������
	private FwxxView fv;
	private FwxxDim fd;
	private List<FwxxDim> list;
	private UserDao udao = new UserDao();
	private BaseDao dao = new BaseDao();
	private FwxxDao fdao = new FwxxDao(); 
	private JdDao jdao = new JdDao();
	private String upass1;//�ظ���¼������
	private int userid;
	private int fwxxid;//������ϢID
	private int fwid;
	private int jdid;
	private int page = 1;//ҳ��
	private int pageSize =3;
	private int max;//���ҳ
	public String denglu(){
		//�õ�jspҳ����û��������벢������session��
		System.out.println("�����¼ҳ��");
		user = udao.queryNameAndPwdza(user);
		if(user!=null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			return "login_success";
		}else{
			return "input";
		}
	}
	//ע��
	public String zhuxiao(){
		System.out.println("����ע��ҳ��");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "login";
	}
	//תȥ��ҳ(�����ơ���)
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
	//ע���û�
	public String zhuce(){
		System.out.println("����ע��ҳ��");
		int num = dao.insert("seq_user",user);
		System.out.println(upass1+"=======");
		if(num>0&&user.getUpass().equals(upass1)){
			return "index";
		}else{
			return "zhuce_filed";
		}
	}
	//��ҳ��ѯ
	public String currentPage(){
		System.out.println("�����ҳ��ѯ");
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
	//����ҳ��
	public String guanli(){
		System.out.println("�������ҳ��");
		info = fdao.queryById(Tbl_Fwxx.class, userid);
		System.out.println("======="+info);
		System.out.println(userid);
		ServletActionContext.getRequest().getSession().setAttribute("userid", userid);
		user = (Tbl_User) udao.queryById(Tbl_User.class, userid);
		return "guanli_success";
	}
	
	//ɾ�������ݷ�����ϢID��ɾ����
	public String del(){
		System.out.println("����ɾ������");
		int num = dao.delete(Tbl_Fwxx.class, fwxxid);
		System.out.println("fwxx========"+fwxxid);
		if(num>0){
			return "del_success";
		}else{
			return "del_filed";
		}
	}
	//ɾ��֮��Ĺ���
	public String reguanli(){
		System.out.println("����ɾ��֮��Ĺ���ҳ��");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object attribute = session.getAttribute("userid");
//		System.out.println(attribute);
		info = dao.ReQueryById(Tbl_Fwxx.class, attribute);
//		System.out.println("======="+info);
//		System.out.println(userid);
		user = (Tbl_User) udao.ReQueryById(Tbl_User.class, attribute);
		return "guanli_success";
	}
	//�����޸�
	public String enterupdate(){
		System.out.println("�����޸�");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object attribute = session.getAttribute("userid");
		xx = (Tbl_Fwxx) dao.queryById(Tbl_Fwxx.class, fwxxid);
		System.out.println(xx);
		return "enter_update";
	}
	//�޸Ĳ���
	public String update(){
		System.out.println("�����޸Ĳ���");
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
	//����
	public String add(){
		System.out.println("���뷢��ҳ��");
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
	//����
	public String find(){
		System.out.println("��������");
		System.out.println(fwid);
		int userid = fdao.queryById(fwid);
		user = (Tbl_User) udao.queryById(Tbl_User.class, userid);
		xx = (Tbl_Fwxx) dao.queryById(Tbl_Fwxx.class, fwid);
		int lxid = xx.getLxid();
		lx = (Tbl_Fwlx) udao.queryById(Tbl_Fwlx.class, lxid);
		return "find_success";
	}
	//�߼���ѯ
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
