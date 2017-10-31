<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
  </head>
  
  <body>
  <!-- struts2只解决了post提交编码 get提交没有 -->
  	<s:form action="users_regist" method="post"> <!-- theme="simple" -->
  		用户名：<s:textfield name="user.uname"></s:textfield><s:fielderror fieldName="user.uname"></s:fielderror><br/>
  		密码：<s:password name="user.upwd"></s:password><br/>
  		年龄：<s:textfield name="user.age"></s:textfield ><s:fielderror fieldName="msg.error.age"/><s:fielderror fieldName="user.age"></s:fielderror><br/>
  		生日：<s:textfield name="user.birthday"></s:textfield>
  		<div >
  		<s:fielderror fieldName="user.birthday"/>
  		</div>
  		<br/>
  		薪水：<s:textfield name="user.salary"></s:textfield><br/>
  		<s:submit value="提交"></s:submit>
  		<s:reset value="重置"></s:reset>
  	</s:form>
   <s:debug></s:debug>
  
  	
  </body>
</html>
