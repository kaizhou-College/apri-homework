<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tag2.jsp' starting page</title>
  </head>
  
  <body>
   ${ulist[0].name}
   <br/>
   <c:forEach items="${ulist}" var="u">
   		${u.id }<br/>
   		${u.name }<br/>
   		------------------------------<br/>
   </c:forEach>
   
   <br/>
   <s:iterator value="ulist" var="u">
   		${u.id }<br/>
   		${u.name }<br/>
   		------------------------------<br/>
   		<s:property value="#u.id"/><br/>
   		<s:property value="#u.name"/><br/>
   		------------------------------<br/>
   </s:iterator>
  <br/> ====================普通循环========================<br/>
   <s:iterator begin="1" end="10" step="1" var="i">
   		<s:if test="#i%2==0">
   			我是偶数<s:property value="#i"/><br/>
   		</s:if>
   		
   </s:iterator>
   
   
   <br/>
  </body>
</html>
