<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  
  <body>
  	<!-- contains判断是否包含boolean类型 -->
  	${fn:contains("pyjmn","pyj")}
  	
  	<!-- containsIgnoreCase判断是否一样 boolean类型-->
  	${fn:containsIgnoreCase("潘尹婕","尹峥")}
  	
  	<!-- endsWith 检测字符串是否以指定类型结束 boolean类型-->
  	${fn:endsWith("yjnsczx","x")}
  	
  	 <!--escapeXml 是否过滤为xml文档???  待完善
  	<c:set var="str" value="pyjzuimei"/>
  	${fn:escapeXml(str)}  	-->

  	
  	<!-- indexOf 返回指定字符串在一个字符串中第一次出现的索引值 int类型  从0开始-->
  	${fn:indexOf("pyjzuimei","z")}
  	
  	<!-- join 以一个字符串作为分隔符，将一个字符串数组中的字符合并为一个字符串并返回合并后的字符串 
  	${fn:join(pyj,".")} 待完善-->
  	
  	<!-- length 返回一个集合或数组大小，或返回字符串中的字符个数，int类型 -->
  	<%ArrayList list=new ArrayList();
  		list.add("pyj");
  		list.add("zui");
  		list.add("mei");
  		list.add("deng");
  	 %>
  	 <%request.getSession().setAttribute("list",list);%>
  	${fn:length(list)} 
  	
  	<!-- replace将一个函数中指定的字符串替换成另一个指定的字符串 -->
  	${fn:replace("dengquanyunzuisha","sha","mei")}
  	
  	<!-- split以指定字符串作为分隔符，将一个字符串分割成字符串数组并返回这个字符串数组
  	${fn:split(pyjzuimei, ";")} 待完善 -->
  	
  	<!-- startsWith 检测字符串是否以指定类型开始 boolean类型-->
  	${fn:startsWith("yjnsczx","x")}
  	  	
  	<!--substring 截取一个字符串的子字符串并返回截取到的子字符串 包头不包尾 -->
  	${fn:substring("shijiezuimeideshipyjl",6,20)}
  	
  	<!-- substringAfter截取并返回一个字符串中的指定字符串第一次出现之后的子字符串-->
  	${fn:substringAfter("pyjshizuihaokande","i")}
  	
  	<!-- substringBefore获取从开始到某个字符串所在位置的子字符串  包头不包尾-->
  	${fn:substringBefore("pyjzuiaiczx","a")}
  	
  	<!-- toLowerCase 将字符串变小写 -->
  	${fn:toLowerCase("PYJ")}
  	
  	<!-- toUpperCase 将字符串中所有字符变大写 -->
  	${fn:toUpperCase("pyjzuimei")}
  		
  	<!-- trim 删除字符串首尾的空格 -->	
  	${fn:trim(" JavaEl  ")}
  </body>
</html>
