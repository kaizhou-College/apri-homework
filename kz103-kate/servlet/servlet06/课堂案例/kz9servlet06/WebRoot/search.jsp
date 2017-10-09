<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ajax模糊搜索</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript">
  
  	var ajax;
    function search(obj){
		//1,得到手机
		createAjax();
		//2, 拨 get
		var method = "get";
		var url = "SearchServlet?uname="+encodeURI(encodeURI(obj.value))+"&"+Math.random();
		ajax.open(method,url,true);
		//3,打
		ajax.send(null);
		//4,接
		ajax.onreadystatechange=cb;
	}
	function cb(){
		if(ajax.readyState ==4&&ajax.status==200){
			var names = ajax.responseText;
			var nameArr = names.split("-");
			var htmlText ="";
			document.getElementById("search").style.display="inline"
			for(var i=0;i<nameArr.length;i++){
				htmlText += "<div  class='suggest_link' onmouseover='over(this)' onmouseout='out(this)' onclick='dj(this)'>"+nameArr[i]+"</div>"
			}
			document.getElementById("search").innerHTML=htmlText;
		}
	}
	function out(obj){
		obj.className="suggest";
	}
	function over(obj){
		obj.className="suggest_link_over";
	
	}
	function dj(obj){
		//1,将值放入文本框
		document.getElementById("uname").value=obj.innerHTML;
		//2,下面的提示隐藏
		document.getElementById("search").style.display="none"
	}
	function createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
}
    </script>
    
    
  </head>
  
  <body>
   		用户名:<input name="uname" id="uname" onkeyup="search(this)" size="30">
   		<div id="search" style="width:200px;margin-left:47px;"></div>
  </body>
</html>
