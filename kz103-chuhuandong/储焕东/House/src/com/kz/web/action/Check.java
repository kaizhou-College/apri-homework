package com.kz.web.action;

import org.apache.struts2.ServletActionContext;

public class Check {
	public String check(){
		boolean isUpdate = (Boolean) ServletActionContext.getRequest().getSession().getAttribute("isUpdate");
		if(isUpdate){
			return "update";
		}else{
			return "add";
		}
	}
}
