package com.wtg.Action;

import java.util.Random;
//要生成get/set方法
public class DynamicAction {
	private String url;
	private String name;
	public String test4(){
		int i=new Random().nextInt(2);
		if (i==1) {
			url="b.jsp";
		}else{
			url="c.jsp";
		}
		name="二狗子";
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
