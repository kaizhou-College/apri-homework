package com.kz.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.StreetDao;
import com.kz.entity.Street;
import com.opensymphony.xwork2.ActionSupport;
/*
 * <streets>
 * 	<street id="1000">
 * 		<name>知春路</name>
 *  <street>
 * <street id="1001">
 * 		<name>中关村大街</name>
 *  <street>
 * <streets>
 */
public class StreetAction extends ActionSupport{
	private Street street;
	private StreetDao sd = new StreetDao();
	//ajax请求   局部刷新 不需要进行页面的跳转 不需要return""
	public void queryById() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码 
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		//System.out.println("进入 queryById....."+street.getDistrict_id());
		//1,根据区id查询街道
		List<Street> streets = sd.findByDisId(street.getDistrict_id());
		//2,将街道信息发给ajax---text  xml
		StringBuffer xml = new StringBuffer();
		xml.append("<streets>");
		for(Street s :streets){
			xml.append("<street id='"+s.getId()+"'>");
			xml.append("<name>"+s.getName()+"</name>");
			xml.append("</street>");
		}
		
		xml.append("</streets>");
		//发送响应---respose
		out.print(xml.toString());
		out.close();
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	
}
