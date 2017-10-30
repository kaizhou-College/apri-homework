<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ui.jsp' starting page</title>
    
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
   	<s:form action="" method="post" theme="simple">
   		用户名:<s:textfield name="users.uname"></s:textfield><br/>
   		密码:<s:password name="users.upwd"></s:password><br/>
   		性别:<s:radio list="#{0:'男',1:'女'}" value="1" name="users.sex"></s:radio><br/>
   		爱好:<s:checkboxlist list="#{0:'看电影',1:'玩游戏'}" value="{0}" name="users.hb"></s:checkboxlist><br/>
   		省份:<s:select list="#{1:'北京',2:'上海'}" name="users.province" value="2"></s:select><br/>
   		头像:<s:file name="users.head"></s:file><br/>
   		备注:<s:textarea name="users.info"></s:textarea><br/>
   		<s:submit value="提交"></s:submit>
   		<s:reset value="重置"></s:reset>
   	</s:form>
   	
   	<s:debug></s:debug>
  </body>
</html>
