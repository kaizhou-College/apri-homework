<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
  

  </head>
  
  <body>
   			<form action="Myservlet" method="post">
   			<p>用户：<input type="text" name="name" value=""></p>
    		<p>密码：<input type="password" name="pwd" value=""></p>
    		<p>性别：<label><input type="radio" name="sex" value="男">男</label>
    				<label><input type="radio" name="sex" value="女">女</p></label>
    		<p>爱好：<input type="checkbox" name="box" value="渗透测试">渗透测试
    				<input type="checkbox" name="box" value="逆向破解">逆向破解</p>
    		<p>个人资料：<textarea type="text" cols="6" rows="6">	</textarea></p>
    				<p><input type="submit" name="xx" value="提交"></p>
   			</form>
  </body>
</html>
