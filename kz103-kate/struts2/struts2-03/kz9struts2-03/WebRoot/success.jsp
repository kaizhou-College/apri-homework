<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
   	耦合方式一：获取request session application域中的值 <br/>
    ${r1}------${s1 }-----${a1 }<br/>
       耦合方式二：获取request session application域中的值 <br/>
    ${r2}------${s2 }-----${a2 }<br/>
       解耦合方式一：获取request session application域中的值 <br/>
    ${r33}------${s3 }-----${a3 }<br/>
    
       解耦合方式二：获取request session application域中的值 <br/>
    ${r4}------${s4 }-----${a4 }<br/>
    
   【 将action的数据的回显方式一：el表达式】<br/>
    ${uname}${pwd}:
  <br/> 原理：struts2中jsp的el表达式先到4大域对象拿值，
    如果四大域中无法得到，就会去值栈的根部(root)来获取。<br/>
   
   <br/>struts2中的request对象真面目：<br/>
   <%=request%><br/>
 <br/>  【将action的数据的回显方式二：ognl表达式】<br/>
   使用ognl显示值栈的根部的数据：直接写属性名<br/>
  <s:property value="uname"/><br/>
  <s:property value="pwd"/><br/>
    使用ognl显示值栈的非根部的数据：必须在属性前加：#<br/>
   <br/>下面等价于：request.getParameter("uname");<br/>
   <s:property value="#request.uname"/><br/>
   <s:property value="#parameters.uname"/><br/>
   <s:property value="#attr.uname"/><br/>
   
   <s:iterator value="#request.list" var="user">
  		<s:if test="#user.pwd>124">
  			<s:property value="#user.uname"/>密码大于124-----<s:property value="#user.pwd"/>
  		</s:if><br/>
  		<s:elseif test="#user.pwd>122">
  			<s:property value="#user.uname"/>密码大于122-----<s:property value="#user.pwd"/>
  		</s:elseif><br/>
  		<s:else>
  			<s:property value="#user.uname"/>其他情况-------<s:property value="#user.pwd"/>
  		</s:else><br/>
   </s:iterator><br/>
   
   users在值栈的根部：<br/>
   <s:iterator value="users" var="user">
   		<s:property value="#user.uname"/>---><s:property value="#user.pwd"/>
   </s:iterator>
   
   <br/> 查看值栈的内容:struts2标签库<br/>
   <s:debug></s:debug>
    
    
  </body>
</html>
