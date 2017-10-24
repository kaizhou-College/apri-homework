package com.kz.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;

//刘教授（男科医生）
public class ManAction implements Action{//父接口
	
	public ActionForward/*String*/ excute(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("刘教授在看病");
		//1,到哪里拿结果 2,怎么去拿去拿结果(转发去/重定向)
		return new ActionForward("success", true);//默认到success.jsp拿结果
		//springMVC
		//return "redirect:success";
	}

}
