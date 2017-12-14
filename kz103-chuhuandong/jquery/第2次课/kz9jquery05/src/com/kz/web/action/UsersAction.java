package com.kz.web.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.kz.dao.UsersDao;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
public class UsersAction extends ActionSupport implements ServletResponseAware{
	private HttpServletResponse response;
	private int page;
	private int rows;
	public void list(){
		response.setContentType("text/plain;charset=utf-8");
		System.out.println("����action"+page+"\t"+rows);
		//biz--dao----���ݿ�
		List<Users> users = new UsersDao().findByPage(page, rows);
		//google��˾��Դ��һ��������תΪjson�ַ����Ĺ���
		//Gson gson = new Gson();
		//gson.toJson()
		//������תΪjson�ַ���
		Gson gson = new Gson();
		String jsonUsers = gson.toJson(users);
		String json = "{\"total\":21,\"rows\":"+jsonUsers+"}";
		System.out.println("jsonUsers"+json);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}
	
}
