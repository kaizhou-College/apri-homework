package com.wtg.Util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.xml.registry.infomodel.User;

import com.wtg.entity.Book;
/**
 * 
 * @author WTG
 *  <table align="center" border="1">
    	<tr>
    		<td>UserName:</td>
    		<td>¶þ¹·×Ó</td>
    	</tr>
    	<tr>
    		<td>age:</td>
    		<td>22</td>
    	</tr>
    	<tr>
    		<td>email:</td>
    		<td>test@test.com</td>
    	</tr>
    
    </table>
 */
public class Table extends SimpleTagSupport{
	private ArrayList<Book> user;

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter out = getJspContext().getOut();
		StringBuffer sql=new StringBuffer("<table align='center' border='1'>");
		
		for (int i = 0; i < user.size(); i++) {
			sql.append("<tr>");
				sql.append("<td>"+user.get(i)+"</td>");
				sql.append("<td></td>");
				sql.append("<td></td>");
				sql.append("<td></td>");
			sql.append("</tr>");
		}
		sql.append("</table>");
		out.print(sql.toString());
	}

	public ArrayList<Book> getUser() {
		return user;
	}

	public void setUser(ArrayList<Book> user) {
		this.user = user;
	}
	
}
