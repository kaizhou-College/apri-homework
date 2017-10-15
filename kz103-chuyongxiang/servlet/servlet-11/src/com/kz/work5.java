package com.kz;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import entity.UserInfo;

public class work5 {
	public class TableTag extends SimpleTagSupport{
		UserInfo user ;
		public void doTag() throws JspException, IOException {
			JspWriter out = getJspContext().getOut();
			StringBuffer str = new StringBuffer();
			str.append("<table align='center' border='1'>");
			str.append("<tr>");
			str.append("<td>id</td>");
			str.append("<td>"+user.getId()+"</td>");
			str.append("</tr>");
			str.append("<tr>");
			str.append("<td>name</td>");
			str.append("<td>"+user.getName()+"</td>");
			str.append("</tr>");
			str.append("<tr>");
			str.append("<td>age</td>");
			str.append("<td>"+user.getAge()+"</td>");
			str.append("</tr>");
			out.print(str.toString());
		}
		public UserInfo getUser() {
			return user;
		}
		public void setUser(UserInfo user) {
			this.user = user;
		}
	}
}
