package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	private Users users;
	private List<Users> ulist;
	public String test(){
		//����
		/*users = new Users();
		users.setName("������");
		users.setHobbies(new String[]{"��ߣ","�Լ�","˯��","�ϲ���"});*/
		
		//����
		ulist = new ArrayList<Users>();
		
		
		ulist.add(new Users("11","1����"));
		ulist.add(new Users("22","2����"));
		ulist.add(new Users("33","3����"));
		ulist.add(new Users("44","4����"));
		ulist.add(new Users("55","5����"));
		
		return SUCCESS;
	}
	private int[] hobbies;
	public String update(){
		//��ȡ��ֵ ���������ݿ�
		System.out.println("users=="+users);
		for(int id:hobbies){
			System.out.println("id="+id);
		}
		return "";
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Users> getUlist() {
		return ulist;
	}
	public void setUlist(List<Users> ulist) {
		this.ulist = ulist;
	}
	public int[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(int[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
	
}
