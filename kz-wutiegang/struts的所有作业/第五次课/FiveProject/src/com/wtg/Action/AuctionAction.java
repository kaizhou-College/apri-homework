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
	//拦截器根据文件名自动获取文件类型和文件名字
	private String uploadContentType;	
	private String uploadFileName;
	public String query(){
		
		System.out.println("进入query的方法里面");
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
	//高级查询加分页
	public String gaoJi(){
		System.out.println("进入gaiji查询的方法");
		if (page==0) {
			page=1;
		}
		ActionDao actiondao=new ActionDao();
		max=actiondao.maxPage(action, 2);
		
		auction = actiondao.selByPage(action, page, 2);
		
		return "gaoJi_success";
	}
	public String find(){
		System.out.println("进入了find 方法里面");
		if (page==0) {
			page=1;
		}
		
		max=basedao.MaxPage(Auction.class, 2);
		//System.out.println(page+"====page====max===="+max);
		auction = basedao.selByPage(Auction.class, page, 2);
		return "find_success";
	}
	//根据id查到对应的数据
	public String byId(){
		System.out.println("进入byid里面");
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
	//新增
	public String add(){
		System.out.println("进入add里面");
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
	//更新//文件上传
	public String update(){
		
			System.out.println(upload+"===华福update酒店=="+uploadContentType+"===开服活动=="+uploadFileName);
			//文件放到服务器里面
			String pp=getNewFileName(uploadFileName);
			File file=new File("C://Tomcat 6.0/webapps/FiveProject/images/"+pp);
			//再用FileUtils的copyFile方法把文件拷贝到upload文件里面
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			action.setAuctionpic(pp);
			action.setAuctionpictype(uploadContentType);
			System.out.println("进入更新页面"+action.getAuctionid()+action);
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
	//注销
	public String pass(){
		System.out.println("进入pass里面");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "pass_success";
	}
	
	
	public String Zhuce(){
		System.out.println("进入Zhuce里面");
		return "Zhuce_success";
	}
	public String fb(){
		System.out.println("进入fb里面");
		return "fb_success";
	}
	public String manager(){
		System.out.println("进入manager里面");
		return "manager_success";
	}
	
	//根据旧名字的后缀得到新名字的的方法
	public String getNewFileName(String oldFileName){
		System.out.println("进入getNewFileName里面");
		//第一步：得到随机字符串
		String uuid = UUID.randomUUID().toString();
		//第二步：把随机字符串拼接到根据旧名字查找到的后缀上
		String suffix = oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
		System.out.println(suffix+"===hhdh");
		String newFileName=uuid+suffix;
		//第三步：返回值
		return newFileName;
	}
	
	public String jinpai(){
		System.out.println("进入jinpai里面");
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
