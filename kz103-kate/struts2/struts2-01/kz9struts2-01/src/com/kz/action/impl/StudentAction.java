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
	//��ѯ����ѧ��������show.jsp������ʾ
	
	public ActionForward excute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("��ѯѧ��");
		//����dao����
		db = new BaseDao<Student>();
		dataList = db.queryDataPage(Student.class, 1, 3);
		//����request��
		req.setAttribute("stus",dataList);
		return new ActionForward("show", false);
	}


}
