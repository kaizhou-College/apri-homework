package com.kz.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.impl.ActionForward;

//一组功能的约定----标准(医生的标准 医生证)
public interface Action {
	//具有看病的行为---方法
	public ActionForward/*String*/ excute(HttpServletRequest req,HttpServletResponse resp);
	
}
