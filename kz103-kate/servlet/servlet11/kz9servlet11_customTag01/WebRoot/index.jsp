<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- el函数库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.kaizhouedu.com/kz/el/functions" prefix="kzfn" %>
<!-- 使用jstl标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.kaizhouendu.com/jsp/jstl/kz/core" prefix="kztag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
   ${fn:contains("abcde","abc")}
   ${fn:toUpperCase("abcde")}
   ${kzfn:strIsNotNull("abc")}
   ${kzfn:dateToString("2017-1-1 12:12:12")}
   
   
   <c:set var="now" value="<%=new Date()%>"> </c:set>
   <fmt:formatDate value="${now}" pattern="yyyy年MM月dd日 "/>
   
   <c:set var="balance" value="120000.2309" />
   <fmt:formatNumber 
            maxFractionDigits="2"  value="${balance}" ></fmt:formatNumber>
   <kztag:sayHello></kztag:sayHello>
  　<kztag:kzif test="${1==2}"> 我是条件为true时执行的代码</kztag:kzif>
   <!-- 简单自定义标签的应用：自定义分页标签 -->
   
  
  </body>
</html>
