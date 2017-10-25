package com.kz.action;

import java.util.Random;

public class DynamicAction {
	private String url;
	private String name;
	
	public String test4(){
		int i = new Random().nextInt(2);
		if(i==1){
			url = "reg1.jsp";
		}else{
			url= "reg2.jsp";
		}
		name= "¶þ¹·×Ó";
		return "success";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
