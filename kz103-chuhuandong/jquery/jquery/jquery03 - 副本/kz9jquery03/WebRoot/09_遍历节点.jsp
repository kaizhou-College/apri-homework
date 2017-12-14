<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>09_遍历节点.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	</head>
	 
	<body>
				
		
		 <ul id="city">
		 	 <li id="bj" name="beijing">太子
				<ul id="u2">
					<li id="sz">孙子</li>
					<li>孙子22</li>
				</ul>
			</li>
			 <li id="tj" name="tianjin">天津</li>
			 <li id="nj" name="nanjing">南京
			 	</li>
			 	 <li id="nj" name="nanjing">南京
			 	</li>
		 </ul>
		
	</body>
	<script type="text/javascript">
		//该方法只考虑子元素而不考虑任何后代元素.
		///	alert($("#bj").children().length);
//			取得相邻元素的下一个同级元素
		//alert($("#bj").next().text());//天津
		//取得相邻元素的上一个同级元素
		////alert($("#tj").prev().text());//太子
		//找出所有兄弟元素
		//alert($("#tj").sublings());	//太子  南京
			//find
		//选获取元素通过find 找到对应的标签的子元素的集合...
		alert($("ul").find("#u2").text());
	
	</script>
   
</html>



