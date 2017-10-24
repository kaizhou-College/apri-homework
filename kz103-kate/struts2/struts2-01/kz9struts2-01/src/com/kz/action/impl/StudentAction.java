package com.kz.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;
import com.kz.dao.BaseDao;
import com.kz.entity.Student;

public class StudentAction implements Action {
	private BaseDao db;
	private List<Student> dataList;
	//查询所有学生，跳到show.jsp进行显示
	
	public ActionForward excute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("查询学生");
		//调用dao方法
		db = new BaseDao<Student>();
		dataList = db.queryDataPage(Student.class, 1, 3);
		//放入request域
		req.setAttribute("stus",dataList);
		return new ActionForward("show", false);
	}


}
