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
    
    <title>My JSP 'Zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
	<META content="text/html; charset=utf-8" http-equiv=Content-Type>
	<LINK rel=stylesheet type=text/css href="css/style.css">
	<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  </head>
  
  <body>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<s:form action="ZhuceAction_Zhuce" method="post" theme="simple">
	<DIV class=infos>
	<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><s:textfield name="name" cssClass="text"></s:textfield></TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><s:textfield name="password" cssClass="text" type="password"></s:textfield></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><s:textfield name="repassword" cssClass="text" type="password"></s:textfield></TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><s:textfield name="telephone" cssClass="text" type="text"></s:textfield></TD></TR>
  <TR>
    <TD class=field>用户姓名：</TD>
    <TD><s:textfield name="username" cssClass="text" type="text"></s:textfield></TD></TR></TBODY></TABLE>
<DIV class=buttons>
<s:submit value="立即注册"></s:submit>
</DIV></DIV>
</s:form>
</DIV></DIV></DIV>
<!--<FORM action=ZhuceAction_Zhuce method=post>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=name> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword> </TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone> </TD></TR>
  <TR>
    <TD class=field>用户姓名：</TD>
    <TD><INPUT class=text type=text name=username> </TD></TR></TBODY></TABLE>
<DIV class=buttons>
<INPUT value=立即注册 type="submit">
</DIV></DIV></FORM></DIV></DIV></DIV>
--><DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>

  </body>
</html>
