package com.kz.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.entity.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest req,HttpServletResponse res);
}
