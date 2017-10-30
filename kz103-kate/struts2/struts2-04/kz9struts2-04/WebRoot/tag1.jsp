<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tag1.jsp' starting page</title>
  </head>
  
  <body>
  	<!-- 
  		<s:property value="" default="" escape=""/>
  		value:值栈中获取值的key
  		default:值栈中无法获取值，就采用默认值
  		escape：值是否解析为字符串 
  			true ：按字符串解析
  			false: html标签解析
  	 -->
  	<br/><!--  普通用法--><br/>
  	<s:property value="name" />
  	<s:property value="#request.sname"/>
  	<br/><!--特殊用法--><br/>
  	<s:property value="abc" default="我是默认值" />
  	<s:property value="'<html>'" escape="false"/>
  	
  	<%	
  		String uname= "狗子";
  		//out.print(uname);
  	 %>
  	<!-- 字符串必须加'' 数字不需要加 
  	scope:request session application  pageContext
  	默认是：pageContex
  	-->
  	<s:set value="'狗子'" var="uname" scope=""></s:set>
  	<s:property value="#uname"/>
  	<!-- 
  		Users u = new Users();
  		u.setId(24);
  		u.setName("二狗子");
  	 -->
  	<s:bean name="com.kz.entity.Users" var="u">
  		<s:param name="#u.id" value="24"></s:param>
  		<s:param name="#u.name" value="'二娃子'"></s:param>
  	</s:bean>
  	
  	<s:property value="#u.id"/><br/>
  	<s:property value="#u.name"/><br/>
  	
  	
  	
  	
  	<s:debug></s:debug>
  </body>
</html>
