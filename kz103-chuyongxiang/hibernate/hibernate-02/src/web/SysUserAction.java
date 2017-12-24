package web;

import java.util.List;

import biz.SysUserBiz;

import entity.SysUser;

public class SysUserAction {
	private int id;
	private String username;
	private String password;
	private SysUser sysuser;
	private List sysuserlist;
	
	
	
	public String select(){
		System.out.println();
		sysuserlist=SysUserBiz.select(SysUser.class);
		System.out.println("�����ﰡ"+sysuserlist);
		return "select_ok";
		
	}
	
	//ȥ�޸�ҳ��
	public String toedit(){
		System.out.println("���"+id);
		sysuser=SysUserBiz.toedit(id);
		System.out.println("�����￴��"+sysuser);
		return "toedit";
	}
	
	//�޸�
	public String edit(){
		System.out.println(id);
		System.out.println(username);
		System.out.println(password);
		SysUser sysuser=new SysUser();
		sysuser.setUsername(username);
		sysuser.setPassword(password);
		System.out.println("��aaaa��"+id);
		SysUserBiz.edit(sysuser,id);
		return "edit_ok";
		
	}
	
	//ɾ��
	public String delete(){
		System.out.println("���"+id);
		SysUser sysuser=new SysUser();
		sysuser.setId(id);
		System.out.println(sysuser);
		SysUserBiz.delete(sysuser);
		return "delete_ok";
	}
	
	




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public SysUser getSysuser() {
		return sysuser;
	}


	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}


	public List getSysuserlist() {
		return sysuserlist;
	}


	public void setSysuserlist(List sysuserlist) {
		this.sysuserlist = sysuserlist;
	}
	
}
