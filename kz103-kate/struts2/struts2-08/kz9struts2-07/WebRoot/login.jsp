<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
	<s:form action="user_login" method="post">
		<s:text name="uname"></s:text>:
		<s:textfield name="username"></s:textfield><br/>
		<s:fielderror fieldName="uage.error"></s:fielderror>
		<s:text name="upwd"></s:text>:
		<input type="password" name="userpwd"/><br/>
		<input type="submit" value="<s:text name='logbtn'/>"/><br/>
		<a href="user_changeLanguage?request_locale=zh_CN">中文</a>
		<a href="user_changeLanguage?request_locale=en_US">English</a>
	</s:form>
	
	<!-- s:i18n标签 -->
	<s:i18n name="com.kz.action.UserAction">
		<s:text name="ageError">
			<s:param  >二狗子</s:param>
			<s:param  >三狗子</s:param>
		</s:text>
	</s:i18n>
  </body>
</html>
