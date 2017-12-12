<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<TITLE>青鸟租房 - 用户登录</TITLE>
	<LINK rel=stylesheet type=text/css href="css/style.css">
	<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
  </head>
  
  <body>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DIV class=box>
<H4>用户登录</H4>
<s:form action="LoginAction_Login" method="post" namespace="/" theme="simple">
	<DIV class=infos>
	<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><s:textfield name="name" cssClass="text" id="user_name" value="admin"></s:textfield></TD></TR>
	<TR>
    <TD class=field>密　　码：</TD>
    <TD><s:textfield name="password" cssClass="text" type="password" id="user_password" value="123"></s:textfield> </TD></TR>
	</TBODY></TABLE>
	<DIV class=buttons> 
	<s:submit value="登陆"></s:submit>
	<INPUT onclick='document.location="jsp/Zhuce.jsp"' value=注册 type=button> 
	</DIV>
	
	</DIV>

</s:form>
	</DIV>
	</DIV>
	</DIV>
<!--<FORM id=user method=post name=user action=LoginAction_Login>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD> <input type="text" class="text" name="name" /> 
    <INPUT id=user_name class=text type=text name=name> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD> <input type="password" class="text" name="password" /> 
     <INPUT id=user_password class=text type=password name=password> </TD></TR>
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						</TBODY></TABLE>
<DIV class=buttons> <INPUT value=登陆 type="submit"> <INPUT onclick='document.location="jsp/Zhuce.jsp"' value=注册 type=button> 
</DIV></DIV></FORM></DIV></DIV></DIV>
--><DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>

  </body>
</html>
