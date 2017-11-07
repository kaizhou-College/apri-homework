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
    <title>My JSP 'ognl.jsp' starting page</title>
  </head>
  
  <body>
  	{lis<!-- ognl取实例属性 :root中数据都不需要加#-->
  	<ul>
  		<li>ognl获取普通实例属性:<s:property value="uname"/> </li>
  		<li>ognl获取对象实例属性:<s:property value="users.uname"/> </li>
  		<li>ognl获取对象实例属性的对象属性:<s:property value="users.dog.dname"/> </li>
  	</ul>
  	
  	<!-- ognl调用实例方法 -->
  	
  	<ul>
  		<li>ognl调用Action的有参的实例方法:<s:property value="setUname('王二狗')"/> </li>
  		<li>ognl调用Action的无参的实例方法:<s:property value="getUname()"/> </li>
  		<li>ognl调用实例属性的无参的实例方法:<s:property value="users.setUname('鸭蛋')"/> </li>
  		<li>ognl调用实例属性的无参的实例方法:<s:property value="users.getUname()"/> </li>
  	</ul>
  	
  	
  	<!-- ognl静态属性 -->
  	<ul>
  		<li>ognl调用Action静态属性: <s:property value="@com.kz.action.OgnlAction@staticStr"/> </li>
  		<li>ognl调用实体类静态属性:<s:property value="@com.kz.entity.Users@SCHOOL"/></li>
  		<li>调Math类的静态属性:<s:property value="@@PI"/> </li>
  	</ul>
  	<!-- ognl调用静态方法 -->
  	<ul>
  		<li>ognl调用Action的静态方法: <s:property value="@com.kz.action.OgnlAction@getA()"/> </li>
  	</ul>
  	<!-- ognl调用构造方法 -->
  	<ul>
  		<li>ognl调用构造方法:<s:property value="new com.kz.entity.Dog(1,'abc').getDname()"/> </li>
  	</ul>
  	<!-- ognl取list集合 -->
  	<ul>
  		<li>ongl取list集合:<s:property value="list"/> </li>
  		<li>ongl取list集合中某个对象:<s:property value="list.get(0)"/></li>
  		<li>ongl取list集合中某个对象:<s:property value="list[0]"/> </li>
  		<li>ongl取list集合中某个对象的普通属性:<s:property value="list.get(0).uname"/></li>
  		<li>ongl取list集合中某个对象的对象属性:<s:property value="list.get(0).dog"/></li>
  		<li>ongl取list集合中所有用户对象的名字:<s:property value="list.{uname}"/> </li>
  		<li>ongl取list集合中所有用户对象的某个名字:<s:property value="list.{uname}[1]"/> </li>
  		<li>ongl取list集合中所有用户对象的dog对象的名字:<s:property value="list.{dog}.{dname}"/> </li>
  		<li>ongl取list集合的长度:<s:property value="list.size()"/> </li>
  	</ul>
  	<br/>
  	<%---迭代输出所有用户的所有狗的名字两种方式 --%>
  	<s:iterator value="list" var="u">
  		<s:property value="#u.dog.dname"/>
  	</s:iterator>
  	<s:iterator value="list.{dog}" var="d">
  		<s:property value="#d.dname"/>
  	</s:iterator>
  	
  	<!-- ognl取set集合 -->
  	<ul>
  		<li>ognl取set集合:<s:property value="set"/> </li>
  		<li>ognl取set的第一个元素对象:<s:property value="set.iterator().next().uname"/> </li>
  		<li>ognl取set的的所有用户的名字 :<s:property value="set.{uname}"/> </li>
  		<li>ognl取set的的所有狗的对象的名字 :<s:property value="set.{dog}.{dname}"/></li>
  	</ul>
  	<!-- ognl取map集合 -->
  	<ul>
  		<li>ognl取map集合:<s:property value="map.size()"/> </li>
  		<li>ognl取map所有键的集合: <s:property value="map.keys"/> </li>
  		<li>ognl取map所有值的集合: <s:property value="map.values"/></li>
  		<li>ognl取map指定键的值对象:<s:property value="map[u1]"/> </li>
  		<li>ognl取map指定键的值对象:<s:property value="map.get(u1)"/> </li>
  		<li>ognl取map所有用户对象的名字集合:<s:property value="map.values.{uname}"/> </li>
  	</ul>
  	<%--迭代输出map集合中所有键和值的uname属性 --%>
  	<s:iterator var="m" value="map">
  		<s:property value="#m.key"/>---
  		<s:property value="#m.value.uname"/><br/>
  	</s:iterator>
  	
  	
  	<!-- ognl的条件过滤-->
  	<!-- 显示年龄大于11岁list集合中用户信息
  		?号获取满足条件表达式所有数据
  		^号获取满足条件表达式第一个数据
  		$号获取满足条件表达式最后一个数据
  	 -->
  	<ul>
  		<!-- 单个条件：所有年龄大于11的人的名字 -->
  		
  		<s:property value="list.{? #this.uage>11}.{uname}"/>
  		<!-- 多个条件：所有年龄大于11并且名字以t开头的人的名字 -->
  		<s:property value="list.{? #this.uage>11}.{? #this.uname.startsWith('t')}.{uname}"/>
  		<!-- 多层条件：所有年龄大于11狗的人的id>2的狗的名字 -->
  		<s:property value="list.{? #this.uage>11}.{dog}.{? #this.did>2}.{dname}"/>
  	</ul>
  	
  	
  
   	<s:debug></s:debug>
  </body>
</html>
