package web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import dao.BaseDao;
import dao.FwlxDao;
import dao.FwxxDao;
import dao.JdDao;
import entity.SuperFwxx;
import entity.Tbl_Fwlx;
import entity.Tbl_Fwxx;
import entity.Tbl_Jd;


public class FwxxAction {
	HttpServletRequest req=null;
	private int index;
	int pageIndex=1;//第几页
	int pageSize=3;//每页多少条
	
	private List<Tbl_Fwxx>  fwxx;
	private Tbl_Fwxx fwxx2;
	private Tbl_Fwlx fwlx;
	private Tbl_Jd jd;
	
	
	private int fwid;				//房屋id
	private int uuid;				//用户id
	private int jdid;				//街道id
	private int lxid;				//类型id
	private int shi;				//室
	private int ting;				//厅
	private String fwxxx;			//房屋信息
	private int zj;					//资金
	private String title;			//标题
	private String publishdate;		//发布时间
	private String telephone;		//联系电话
	private String lxr;				//联系人
	
	private int qxid;				//区县id
	private int zj1;				//第二个资金
	private String fabudate;		//发布的相隔时间
	private String mohu;
	
	 private Tbl_Fwxx fwxx3 = new Tbl_Fwxx();
	 private SuperFwxx sf =new SuperFwxx();
	 private List<SuperFwxx> sf2;
	
	 
	//高级查询
		public String superselect(){
			System.out.println("进入了高级查询");
			if(index!=0){
				pageIndex=index;
			}
			fwxx3.setFwid(fwid);
			fwxx3.setJdid(jdid);
			fwxx3.setLxid(lxid);
			fwxx3.setShi(shi);
			fwxx3.setTing(ting);
			System.out.println("这是原来的"+fwxx3);
			
			sf.setQxid(qxid);
			sf.setZj(zj);
			sf.setZj1(zj1);
			sf.setMohu(mohu);
			sf.setFabudate(fabudate);
			System.out.println("新的super======="+sf);
			FwxxDao fd=new FwxxDao();
			
			fwxx=fd.superselect(fwxx3,sf);
			System.out.println("得到的数据是"+fwxx);
			
			return "superselect_ok";
		}
		
		//高级查询的分页查询
		public String superselectpage(){
			System.out.println("进来了高级查询的分页查询");
//			System.out.println("fwxx是"+fwxx);
			req=ServletActionContext.getRequest();
			if(index!=0){
				pageIndex=index; 
			}
			int pageYS=(int) Math.ceil(fwxx.size()/(pageSize*1.0));
			req.setAttribute("pageYS",pageYS);
			req.setAttribute("pageIndex", pageIndex);
			System.out.println("pageYS========="+pageYS);
			System.out.println("pageIndex============="+pageIndex);
			System.out.println("fwxx==========="+fwxx);
			
			
			
			return "superselectpage_ok";
		
		}
		
		
	 
	//跳转到确认修改页面
	public String toupdateview() throws ParseException{
		System.out.println("跳转到那里");
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date a=formatter.parse(publishdate);
		SimpleDateFormat time=new SimpleDateFormat("dd/MM月/yyyy");
		String times=time.format(a);
		System.out.println("times=="+times);
		
		fwxx3.setFwxx(fwxxx);
		fwxx3.setFwid(fwid);
		fwxx3.setJdid(jdid);
		fwxx3.setLxid(lxid);
		fwxx3.setLxr(lxr);
		fwxx3.setPublishdate(times);
		fwxx3.setShi(shi);
		fwxx3.setTelephone(telephone);
		fwxx3.setTing(ting);
		fwxx3.setTitle(title);
		fwxx3.setUuid(uuid);
		fwxx3.setZj(zj);
		System.out.println("房屋信息是"+fwxx3);
		jd=JdDao.findById(jdid);
		System.out.println("jd====="+jd);
		return "toupdateview";
	}
	
	//进行真正的修改
	public String updateok() throws IllegalArgumentException, IllegalAccessException{
		System.out.println("进入修改啦");
		fwxx3.setFwxx(fwxxx);
		fwxx3.setFwid(fwid);
		fwxx3.setJdid(jdid);
		fwxx3.setLxid(lxid);
		fwxx3.setLxr(lxr);
		fwxx3.setPublishdate(publishdate);
		fwxx3.setShi(shi);
		fwxx3.setTelephone(telephone);
		fwxx3.setTing(ting);
		fwxx3.setTitle(title);
		fwxx3.setUuid(uuid);
		fwxx3.setZj(zj);
		System.out.println("房屋信息是"+fwxx3);
		
		int num =BaseDao.update(fwxx3);
		if(num>0){
			System.out.println("修改成功啦");
		}
		return "updateok_ok";
	}
	
	//跳转到确认添加页面
	public String toadd() throws ParseException{
		System.out.println("跳转到那里");
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date a=formatter.parse(publishdate);
		SimpleDateFormat time=new SimpleDateFormat("dd/MM月/yyyy");
		String times=time.format(a);
		System.out.println("times=="+times);
		fwxx3.setFwxx(fwxxx);
		fwxx3.setFwid(fwid);
		fwxx3.setJdid(jdid);
		fwxx3.setLxid(lxid);
		fwxx3.setLxr(lxr);
		fwxx3.setPublishdate(times);
		fwxx3.setShi(shi);
		fwxx3.setTelephone(telephone);
		fwxx3.setTing(ting);
		fwxx3.setTitle(title);
		fwxx3.setUuid(uuid);
		fwxx3.setZj(zj);
		System.out.println("房屋信息是"+fwxx3);
		jd=JdDao.findById(jdid);
		System.out.println("jd====="+jd);
		return "toadd_ok";
	}
	
	
	
	
	//进行添加
	public String add(){
		System.out.println("正在进行添加");
		fwxx3.setFwxx(fwxxx);
		fwxx3.setFwid(fwid);
		fwxx3.setJdid(jdid);
		fwxx3.setLxid(lxid);
		fwxx3.setLxr(lxr);
		fwxx3.setPublishdate(publishdate);
		fwxx3.setShi(shi);
		fwxx3.setTelephone(telephone);
		fwxx3.setTing(ting);
		fwxx3.setTitle(title);
		fwxx3.setUuid(uuid);
		fwxx3.setZj(zj);
		System.out.println("房屋信息是"+fwxx3);
		int num =BaseDao.insert("SYS_C005291", fwxx3);
		if(num>0){
			System.out.println("添加成功啦");
		}
		return "add_ok";
	}
	
	
	//跳转详细信息
	public String toview(){
		System.out.println("准备跳转到查看");
		System.out.println("得到的ID是"+fwxx.get(0).getFwid());
		FwxxDao fd=new FwxxDao();
		fwxx2=fd.findById(fwxx.get(0).getFwid());
		System.out.println("fwxx2======="+fwxx2);
		fwlx=FwlxDao.findById(fwxx2.getLxid());
		System.out.println("fwlx========"+fwlx);
		jd=JdDao.findById(fwxx2.getJdid());
		System.out.println("jd======="+jd);
		return "toview";
	}
	
	//删除
	public String Delect(){
//		System.out.println("进入了Delect");
		System.out.println("auctionId=="+fwxx.get(0).getFwid());
//		System.out.println("正在执行删除");
		int num=BaseDao.delete(Tbl_Fwxx.class,fwxx.get(0).getFwid());
		System.out.println("num=="+num);
		if(num>0){
			System.out.println("删除成功");
			return "Delect_OK";
			
		}else{
			System.out.println("失败了");
			return "NO";
		}
	}
	
	//跳转到修改页面
	 public String update(){
		 int id=fwxx.get(0).getFwid();
		 System.out.println("id==="+id);
		 FwxxDao fd=new FwxxDao();
		 fwxx2=fd.findById(fwxx.get(0).getFwid());
		 System.out.println("fwxx2=="+fwxx2);
		 jd=JdDao.findById(fwxx2.getJdid());
		 System.out.println("jd======="+jd);
		 return "update_ok";
	 }
	
	
	
	
	//login_foem页面分页查询
	public String selectpage(){
//		System.out.println("进入了分页查询");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pageYS=BaseDao.getMax(pageSize, Tbl_Fwxx.class);
		req.setAttribute("pageYS",pageYS);
		req.setAttribute("pageIndex", pageIndex);
//		System.out.println("pageYS========="+pageYS);
//		System.out.println("pageIndex============="+pageIndex);
		fwxx=BaseDao.queryByPage(pageIndex,pageSize, Tbl_Fwxx.class);
//		System.out.println("fwxx==========="+fwxx);
		
		
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		System.out.println(session.getAttribute);
		
		
		
		
		return "selectpage_ok";
	}
	
	//index页面分页查询
	public String selectpage2(){
//		System.out.println("进入了分页查询");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pageYS=BaseDao.getMax(pageSize, Tbl_Fwxx.class);
		req.setAttribute("pageYS",pageYS);
		req.setAttribute("pageIndex", pageIndex);
//		System.out.println("pageYS========="+pageYS);
//		System.out.println("pageIndex============="+pageIndex);
		fwxx=BaseDao.queryByPage(pageIndex,pageSize, Tbl_Fwxx.class);
//		System.out.println("fwxx==========="+fwxx);
		return "selectpage2_ok";
	}
	
	//login页面分页查询
	public String selectpage3(){
//		System.out.println("进入了分页查询");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pageYS=BaseDao.getMax(pageSize, Tbl_Fwxx.class);
		req.setAttribute("pageYS",pageYS);
		req.setAttribute("pageIndex", pageIndex);
//		System.out.println("pageYS========="+pageYS);
//		System.out.println("pageIndex============="+pageIndex);
		fwxx=BaseDao.queryByPage(pageIndex,pageSize, Tbl_Fwxx.class);
//		System.out.println("fwxx==========="+fwxx);
		return "selectpage3_ok";
	}
	
	//管理页面分页查询
	public String selectpage4(){
//		System.out.println("进入了分页查询");
		req=ServletActionContext.getRequest();
		if(index!=0){
			pageIndex=index; 
		}
		int pageYS=BaseDao.getMax(pageSize, Tbl_Fwxx.class);
		req.setAttribute("pageYS",pageYS);
		req.setAttribute("pageIndex", pageIndex);
//		System.out.println("pageYS========="+pageYS);
//		System.out.println("pageIndex============="+pageIndex);
		fwxx=BaseDao.queryByPage(pageIndex,pageSize, Tbl_Fwxx.class);
//		System.out.println("fwxx==========="+fwxx);
//		System.out.println("开始跳转");
		return "selectpage4_ok";
	}
	
	
	
	

	



	public List<SuperFwxx> getSf2() {
		return sf2;
	}



	public void setSf2(List<SuperFwxx> sf2) {
		this.sf2 = sf2;
	}



	public String getMohu() {
		return mohu;
	}



	public void setMohu(String mohu) {
		this.mohu = mohu;
	}



	public SuperFwxx getSf() {
		return sf;
	}



	public void setSf(SuperFwxx sf) {
		this.sf = sf;
	}



	public String getFabudate() {
		return fabudate;
	}



	public void setFabudate(String fabudate) {
		this.fabudate = fabudate;
	}



	public int getZj1() {
		return zj1;
	}



	public void setZj1(int zj1) {
		this.zj1 = zj1;
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


	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public List<Tbl_Fwxx> getFwxx() {
		return fwxx;
	}


	public void setFwxx(List<Tbl_Fwxx> fwxx) {
		this.fwxx = fwxx;
	}


	public Tbl_Fwxx getFwxx2() {
		return fwxx2;
	}


	public void setFwxx2(Tbl_Fwxx fwxx2) {
		this.fwxx2 = fwxx2;
	}


	public Tbl_Fwlx getFwlx() {
		return fwlx;
	}


	public void setFwlx(Tbl_Fwlx fwlx) {
		this.fwlx = fwlx;
	}


	public Tbl_Jd getJd() {
		return jd;
	}


	public void setJd(Tbl_Jd jd) {
		this.jd = jd;
	}


	public int getFwid() {
		return fwid;
	}


	public void setFwid(int fwid) {
		this.fwid = fwid;
	}


	public int getUuid() {
		return uuid;
	}


	public void setUuid(int uuid) {
		this.uuid = uuid;
	}


	public int getJdid() {
		return jdid;
	}


	public void setJdid(int jdid) {
		this.jdid = jdid;
	}


	public int getLxid() {
		return lxid;
	}


	public void setLxid(int lxid) {
		this.lxid = lxid;
	}


	public int getShi() {
		return shi;
	}


	public void setShi(int shi) {
		this.shi = shi;
	}


	public int getTing() {
		return ting;
	}


	public void setTing(int ting) {
		this.ting = ting;
	}


	public String getFwxxx() {
		return fwxxx;
	}


	public void setFwxxx(String fwxxx) {
		this.fwxxx = fwxxx;
	}


	public int getZj() {
		return zj;
	}


	public void setZj(int zj) {
		this.zj = zj;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getLxr() {
		return lxr;
	}


	public void setLxr(String lxr) {
		this.lxr = lxr;
	}




	public Tbl_Fwxx getFwxx3() {
		return fwxx3;
	}




	public void setFwxx3(Tbl_Fwxx fwxx3) {
		this.fwxx3 = fwxx3;
	}



	public int getQxid() {
		return qxid;
	}



	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	
	
}
