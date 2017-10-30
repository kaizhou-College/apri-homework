<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  
  <body>
	<s:form action="listAction!update" namespace="/" method="post">
		<!-- %{}:字符串按ognl表达式来解析   否者当做字符串 -->
	
		用户名：<s:textfield value="%{users.name}" name="users.name" label="用户名"></s:textfield>
		<!-- 
			list:必须是在action中是数组，集合，iterator,map,枚举.....
			name:在action中获取表单值的key
			listKey:后台传过来的标签值
			listValue:前台要显示的值
			value:选中的值
		 -->
		<%--
		<s:checkboxlist list="users.hobbies" name="users.hobbies" value="{'打撸','睡觉','吃鸡'}" ></s:checkboxlist>
		<s:radio list="users.hobbies" name="users.hobbies" value="'打撸'"></s:radio>
		<s:select list="users.hobbies" name="users.hobbies" value="'睡觉'"></s:select>
		
		 --%>
		<s:checkboxlist list="ulist" listKey="id" listValue="name" name="users.hobbies" value="ulist.{id}"></s:checkboxlist>
		
		
		<s:submit value="提交"></s:submit>
	</s:form>  

  </body>
</html>
