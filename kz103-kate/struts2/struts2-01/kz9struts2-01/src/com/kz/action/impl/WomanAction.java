package com.kz.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;

//李教授（妇科）
public class WomanAction implements Action {
	public ActionForward excute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("李教授在看病....");
		//到哪里拿结果
		return null;//"success";
	}


}
