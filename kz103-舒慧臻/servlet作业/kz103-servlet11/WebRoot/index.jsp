<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.shushushu.com/el/functions" prefix="sfn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <!-- 判断在str1 中是否包含str2 
  ${fn:contains("你好，再见！","好")}
  -->
  <!-- 判断输入的字符串是否包含指定的子串，搜索时忽略大小写
  ${fn:containsIgnoreCase("ABHdf","abh") }
   -->
   <!-- 判断str1中是否以str2中的字符结束（是返回true否返回false）
   ${fn:endsWith("你好，再见！","！") }
    -->
    <!-- 待完善  处理特殊字符冲突 escapeXml
    -->
    <!-- 返回指定字符串的下标
    ${fn:indexOf("wwwsinaorg","in")}
     -->
     <!--（有小瑕疵） 将数组中的数据联合成一个新字符串，并使用指定字符格开
   ${fn:join(fn:split("www,sina,org", ","), ";")}
    -->
    <!-- 返回指定字符串的长度 
    ${fn:length("你好，再见！") }
    -->
    <!-- 用指定的字符串替换字符串中的字符（串）
    ${fn:replace("你好，再见！","再见","不再见") }
     -->
     <!-- 把字符串按照指定字符切分  可以通过[index]来选择你需要的那部分字符
     ${fn:split("你好，再见！","，")[0]}
      -->
      <!-- 判断字符串是否以某个子串开始
    ${fn:startsWith("你好，再见！","你好") }
     -->
     <!-- 获取子串  从要获取的子串的开始下标到结束下标
     ${fn:substring("你好，再见！",4,6) }
     -->
     <!-- 获取从某个字符所在位置开始的子串 
     ${fn:substringAfter("你好，再见！","，") }
     -->
     <!-- 某个字符所在位置的子串   截取指定字符前的子串	
     ${fn:substringBefore("你好，再见！","好") }
      -->
      <!-- 转小写
      ${fn:toLowerCase("ABCDEF") }
       -->
       <!-- 转大写
       ${fn:toUpperCase("abcDEF") }
        -->
        <!--  ${fn:trim(" 你好，再见！      ") }-->
   		${sfn:size(list)}
  </body>
</html>
