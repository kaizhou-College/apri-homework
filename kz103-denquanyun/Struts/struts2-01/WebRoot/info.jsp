<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'info.jsp' starting page</title>
  </head>
  
  <body>
  		<form action="info.action" method="post">
  			姓名：<input type="name" name="name"/>
  			籍贯：<select name="address">
  						<option value="china">中国</option>
  						<option value="french">法国</option>
  						<option value="japan">小日本</option>
  				</select>
  				男：<input type="radio" name="sex" value="男"/>女：<input type="radio" name="sex" value="女"/>
  			<input type="submit" value="提交"/>
  		</form>
  </body>
</html>
