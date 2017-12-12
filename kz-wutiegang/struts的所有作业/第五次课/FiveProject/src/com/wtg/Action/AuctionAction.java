package com.wtg.Action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wtg.Dao.ActionDao;
import com.wtg.Dao.BaseDao;
import com.wtg.entity.Auction;
import com.wtg.entity.AuctionUser;

public class AuctionAction extends ActionSupport{
	private List<Auction> auction;
	private int id;
	private int page;
	private int max;
	private int updateId;
	private Auction action;
	private BaseDao basedao=new BaseDao();
	private File upload;
	//�����������ļ����Զ���ȡ�ļ����ͺ��ļ�����
	private String uploadContentType;	
	private String uploadFileName;
	public String query(){
		
		System.out.println("����query�ķ�������");
		try {
			auction = BaseDao.findAll(Auction.class);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "query_success";
	}
	public String delete(){
		System.out.println("delete==="+id);
		Auction auction=new Auction();
		int delete = BaseDao.delete(auction, id);
		if (delete>0) {
			return "delete_success";
		}else{
			return "delete_file";
		}
		
	}
	//�߼���ѯ�ӷ�ҳ
	public String gaoJi(){
		System.out.println("����gaiji��ѯ�ķ���");
		if (page==0) {
			page=1;
		}
		ActionDao actiondao=new ActionDao();
		max=actiondao.maxPage(action, 2);
		
		auction = actiondao.selByPage(action, page, 2);
		
		return "gaoJi_success";
	}
	public String find(){
		System.out.println("������find ��������");
		if (page==0) {
			page=1;
		}
		
		max=basedao.MaxPage(Auction.class, 2);
		//System.out.println(page+"====page====max===="+max);
		auction = basedao.selByPage(Auction.class, page, 2);
		return "find_success";
	}
	//����id�鵽��Ӧ������
	public String byId(){
		System.out.println("����byid����");
		try {
			action = (Auction) BaseDao.load(Auction.class, updateId);
			//System.out.println(action);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "byId_success";
	}
	//����
	public String add(){
		System.out.println("����add����");
		try {
			String pp=getNewFileName(uploadFileName);
			System.out.println(pp+"----djfh");
			File file=new File("C://Tomcat 6.0/webapps/FiveProject/images/"+pp);
			
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			action.setAuctionpic(pp);
			
			action.setAuctionpictype(uploadContentType);
			int add = BaseDao.add("seq_auction", action);
			System.out.println(add+"=======hfhfhfh");
			if (add>0) {
				return "add_success";
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "add_file";
	}
	//����//�ļ��ϴ�
	public String update(){
		
			System.out.println(upload+"===����update�Ƶ�=="+uploadContentType+"===�����=="+uploadFileName);
			//�ļ��ŵ�����������
			String pp=getNewFileName(uploadFileName);
			File file=new File("C://Tomcat 6.0/webapps/FiveProject/images/"+pp);
			//����FileUtils��copyFile�������ļ�������upload�ļ�����
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			action.setAuctionpic(pp);
			action.setAuctionpictype(uploadContentType);
			System.out.println("�������ҳ��"+action.getAuctionid()+action);
			int update=0;
			try {
				update = basedao.update(action, action.getAuctionid());
				if (update>0) {
					return "update_success";
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return "update_file";
	}
	//ע��
	public String pass(){
		System.out.println("����pass����");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "pass_success";
	}
	
	
	public String Zhuce(){
		System.out.println("����Zhuce����");
		return "Zhuce_success";
	}
	public String fb(){
		System.out.println("����fb����");
		return "fb_success";
	}
	public String manager(){
		System.out.println("����manager����");
		return "manager_success";
	}
	
	//���ݾ����ֵĺ�׺�õ������ֵĵķ���
	public String getNewFileName(String oldFileName){
		System.out.println("����getNewFileName����");
		//��һ�����õ�����ַ���
		String uuid = UUID.randomUUID().toString();
		//�ڶ�����������ַ���ƴ�ӵ����ݾ����ֲ��ҵ��ĺ�׺��
		String suffix = oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
		System.out.println(suffix+"===hhdh");
		String newFileName=uuid+suffix;
		//������������ֵ
		return newFileName;
	}
	
	public String jinpai(){
		System.out.println("����jinpai����");
		return "jinpai_success";
	}
	
	public List<Auction> getAuction() {
		return auction;
	}
	public void setAuction(List<Auction> auction) {
		this.auction = auction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public Auction getAction() {
		return action;
	}
	public void setAction(Auction action) {
		this.action = action;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
}
