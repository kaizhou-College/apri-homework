<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.pyj.jsp/jstl/yin" prefix="yj"%>
<!--http://www.pyj.jsp/jstl/yin 可以随意写-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  		<yj:myif test="${1==2}">
  				我是if条件成立时出现
  			<yj:myelseif test="${1==2}"/>
  				我是elseif条件成立时出现
  			<yj:myelse/>
  				我是else条件成立时出现
  		</yj:myif>
  </body>
</html>
