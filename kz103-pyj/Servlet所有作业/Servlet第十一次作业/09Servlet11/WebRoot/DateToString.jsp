<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<%@taglib uri="/mytag" prefix="my"%>
<html>
  <body>
			<%Date myd=new Date(2017-1900,11,12);
			request.setAttribute("myd",myd);
			 %>  
			 <my:myDateToString value="${myd}" parttern="yyyy年MM月dd日"/>
			 
  </body>
</html>
