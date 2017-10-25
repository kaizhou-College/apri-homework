<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>

  </head>
  
  <body>
  	<form action="info.action" method="post">
  		姓名：<input name="uname" type="text"/>
  		<br/>
  		<br/>
  		籍贯：<select name="city">
  				<option value="湖南">湖南</option>
  				<option value="湖北">湖北</option>
  				<option value="河南">河南</option>
  				<option value="上海">上海</option>
  				<option value="广东">广东</option>
  			  </select>
  		<br/>
  		<br/>
  		性别：<label><input name="sex" type="radio" value="男" checked="checked"/>男</label>
  			  <label><input name="sex" type="radio" value="女"/>女</label>
  		<br/>
  		<br/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
