package com.wtg.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.wtg.Dao.StreetDao;
import com.wtg.entity.Street;

public class daAction {
	private int did;
	public void ds() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Street> street = new StreetDao().findSnByDs(Street.class, did);
		
		StringBuffer xml=new StringBuffer();
		xml.append("<streets>");
			for (Street s : street) {
				xml.append("<street id='"+s.getId()+"'>");
					xml.append("<name>"+s.getName()+"</name>");
				xml.append("</street>");
			}
			xml.append("</streets>");
			out.print(xml.toString());
			out.close();
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	
}
