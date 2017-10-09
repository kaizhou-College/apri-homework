<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个jsp,有一个表单，可以输入用户名，选择性别，选择爱好多个复选框，
个人资料的文本域，用post提交到一个Servlet，
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  		<form action="Work4Servlet" method="post"> 
  				用户名:<input type="text" name="name"><br/><br/>
  				性&nbsp;&nbsp;别:<input type="radio" name="sex" value="男" checked="checked">男
  				<input type="radio" name="sex" value="女">女<br/><br/>
  				个人资料:<textarea clos="3" rows="8" name="ziliao"></textarea><br/><br/>
  				爱&nbsp;&nbsp;好:<input type="checkbox" checked="checked" name="aihao" value="买买买">买买买
  				<input type="checkbox"  name="aihao" value="玩玩玩">玩玩玩
  				<input type="checkbox"  name="aihao" value="吃吃吃">吃吃吃<br/><br/>
  				<input type="submit" value="提交">
  		</form>
  </body>
</html>
