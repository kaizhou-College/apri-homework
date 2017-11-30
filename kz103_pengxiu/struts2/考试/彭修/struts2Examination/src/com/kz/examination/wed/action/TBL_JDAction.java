package com.kz.examination.wed.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.kz.examination.dao.TBL_JDDao;
import com.kz.examination.entity.TBL_JD;
import com.kz.examination.entity.TBL_QX;

public class TBL_JDAction {
	//区县的对象
	private TBL_QX tbl_qx;
	
	
	public void ajax(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out =null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<TBL_JD> listQXid = TBL_JDDao.listQXid(tbl_qx.getQxid());
		StringBuffer xml=new StringBuffer("<jds>");
		for (int i = 0; i < listQXid.size(); i++) {
			xml.append("<jd id='"+listQXid.get(i).getJdid()+"'>");
				xml.append("<name>"+listQXid.get(i).getJd()+"</name>");
			xml.append("</jd>");
		}
		xml.append("</jds>");
		out.print(xml.toString());
	}
	public void ajax2(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out =null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(tbl_qx.getQx()+"--就是他");
		List<TBL_JD> listQXid = TBL_JDDao.JdQuLIst(tbl_qx.getQx());
		
		StringBuffer xml=new StringBuffer("<jds>");System.out.println(1);
		for (int i = 0; i < listQXid.size(); i++) {
			System.out.println(1);
			xml.append("<jd id='"+listQXid.get(i)+"'>");
				xml.append("<name>"+listQXid.get(i)+"</name>");
			xml.append("</jd>");
		}
		xml.append("</jds>");
		
		out.print(xml.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TBL_QX getTbl_qx() {
		return tbl_qx;
	}

	public void setTbl_qx(TBL_QX tblQx) {
		tbl_qx = tblQx;
	}
	
	
	
	
	
	
	
}
