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
	//��ҳ�ĳ�ʼ����
	private int pageindex;
	//��ҳ��ÿҳ����
	private int pagesize;
	//��ҳ��תʱ������1��index����
	private int indexces;
	//��ҳ����ҳ��
	private int pageizeZD;
	//��ҳ��ѯ��·��
	private String URL;
	//��ҳ�ļ���
	private List<TBL_FWXX> user_list;
	//������Ϣ��list
	private List<TBL_FWXX> listFwxx;
	//������Ϣ�Ķ���
	private TBL_FWXX tbl_fwxx;
	//�������͵Ķ���
	private List<TBL_FWLX> listFwlx;
	//�ֵ�list
	private List<TBL_JD> jdList;
	private List<TBL_JD> jdIDList;
	//����
	private List<TBL_QX> QxIDList;
	private List<TBL_QX> qxList;
	//�ֵ�������ƴ��
	private String jiequ;
	//������ֵ���duix
	private QuXianJieDao qxjd;
	//
	private List<TBL_QX> listQX;
	//�߼���ѯ�Ķ���
	private QueryView qv;
	//ɾ����action
	//����ʱ��ȡ�Ķ���
	private Tbl_User login;
	
	//���������
	public String addTbl(){
		String format=new SimpleDateFormat("dd/MM��/yyyy").format(new Date());//ϵͳʱ��
		System.out.println("������");
		tbl_fwxx.setPublishdate(format);
		
		int insert = BaseDao.insert(tbl_fwxx);
		if(insert>0){
			return "addTbl";
		}else{
			return "error";
		}
		
	}
	//׼�����ʱ������
	public String  addListTbl() {
		String format=new SimpleDateFormat("yyyy-MM-dd").format(new Date());//ϵͳʱ��
		List<TBL_JD> listJDid = TBL_JDDao.listJDid(qxjd.getJieDao());
		tbl_fwxx.setJdid(listJDid.get(0).getJdid());
		tbl_fwxx.setPublishdate(format);
		tbl_fwxx.setUuid(TBL_USERDao.uname());
		//�ֵ�ƴ��
		TBL_JD jd=new TBL_JD();
		jd.setJdid(tbl_fwxx.getJdid());
		jiequ = TBL_FWXXDao.jiequ(jd);
		//��������
		listFwlx=BaseDao.listID(new TBL_FWLX(tbl_fwxx.getLxid(),null));
		
		return "addListTbl";
	}
	//
	
	
	//n���ʱ���Ǹ��ֵ����������ʾ
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
	
	//�������޸�
	public String updateTbl(){
//		System.out.println("�����Ѿ�������");
//		System.out.println(tbl_fwxx);
		int update = BaseDao.update(tbl_fwxx);
		if(update>0){
			return "updateTBL";
		}else{
			return "error";
		}
		
	}
	
	
	//�������޸�֮ǰ������ʾҳ��
	public String updateListTBL(){
//		System.out.println(qxjd+"--���ؽֵ���");
		List<TBL_JD> listJDid = TBL_JDDao.listJDid(qxjd.getJieDao());
		tbl_fwxx.setJdid(listJDid.get(0).getJdid());
//		System.out.println(tbl_fwxx.getLxid()+"---zg1jius1");
		//�ֵ�ƴ��
		TBL_JD jd=new TBL_JD();
		jd.setJdid(tbl_fwxx.getJdid());
		jiequ = TBL_FWXXDao.jiequ(jd);
		//��������
		listFwlx=BaseDao.listID(new TBL_FWLX(tbl_fwxx.getLxid(),null));
		return "updateListTBL";
	}
	
	
	//�޸ĵ���ʾ
	public String updateList(){
		listFwxx = BaseDao.listID(tbl_fwxx);//������Ϣ
		jdList=TBL_JDDao.JdQxidLIst(listFwxx.get(0).getJdid());//�ֵ���ʾ
		jdIDList = BaseDao.listID(new TBL_JD(listFwxx.get(0).getJdid(),null,null));//�ֵ�Ĭ��ֵ
		QxIDList=BaseDao.listID(new TBL_QX(jdIDList.get(0).getQxid(),null));//����Ĭ��ֵ
		qxList = TBL_QXDao.qxList();//���ص���ʾ
		return "updateList";
	}
	//��ʾ
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
	
	//��ҳ��ѯ�ķ���
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
		
		//�߼���ѯ��Ҫ��ʾ������
		listQX = BaseDao.Select(new TBL_QX());
		return "pageList";
	}
	
	//id��ѯ ������Ϣ
	public String listDetail(){
//		System.out.println("������");
//		System.out.println("���Ҵ���id��"+tbl_fwxx.getFwid());
		listFwxx=BaseDao.listID(tbl_fwxx);
		//�������Ͷ���
		TBL_FWLX fwlx=new TBL_FWLX();
		fwlx.setLxid(listFwxx.get(0).getLxid());
		//�ֵ�����
		TBL_JD jd=new TBL_JD();
		jd.setJdid(listFwxx.get(0).getJdid());
		//����list 
		listFwlx = BaseDao.listID(fwlx);
		//�ֵ�
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
