package work11.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import work11.entity.Users;

/*2，自定义一个表格标签：
		效果图
		——————————————————————————————————
		|UserName:|	二狗子				  |
		——————————————————————————————————
		|age:     |	22      			  |
		——————————————————————————————————
		|email:   |	test@test.com		  |
		——————————————————————————————————
		 <table align="center" border="1">
     	<tr>
     		<td>id</td>
     	</tr>
     	<tr>
     		<td>name</td>
     	</tr>
     	<tr>
     		<td>age</td>
     	</tr>
     </table>
		*/
public class TableTag extends SimpleTagSupport{
	Users user ;
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
}
