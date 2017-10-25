<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
  <body>
  		<form action="info.action">  
  			姓名:<input type="text" name="name"><br/><br/>
  			籍贯:<select name="shi">
  					<option>湖南</option>
  					<option>四川</option>
  					<option>云南</option>
  			    </select><br/><br/>
  			性别:<input type="radio" checked="checked" name="sex" value="男">男
  					<input type="radio" name="sex" value="女">女<br/><br/>
  			<input type="submit" value="提交">
  		</form>
  
  </body>
</html>
