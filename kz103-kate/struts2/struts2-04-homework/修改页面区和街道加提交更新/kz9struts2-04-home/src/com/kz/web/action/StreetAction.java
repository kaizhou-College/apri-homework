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
 * 		<name>֪��·</name>
 *  <street>
 * <street id="1001">
 * 		<name>�йش���</name>
 *  <street>
 * <streets>
 */
public class StreetAction extends ActionSupport{
	private Street street;
	private StreetDao sd = new StreetDao();
	//ajax����   �ֲ�ˢ�� ����Ҫ����ҳ�����ת ����Ҫreturn""
	public void queryById() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		//���ñ��� 
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		//System.out.println("���� queryById....."+street.getDistrict_id());
		//1,������id��ѯ�ֵ�
		List<Street> streets = sd.findByDisId(street.getDistrict_id());
		//2,���ֵ���Ϣ����ajax---text  xml
		StringBuffer xml = new StringBuffer();
		xml.append("<streets>");
		for(Street s :streets){
			xml.append("<street id='"+s.getId()+"'>");
			xml.append("<name>"+s.getName()+"</name>");
			xml.append("</street>");
		}
		
		xml.append("</streets>");
		//������Ӧ---respose
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
