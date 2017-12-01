//alert("哈哈哈哈");
function pxAjax(json){
	var ajax=createAjax();
	if(json.method=="get"){
		ajax.open(json.method,json.url+"?value="+json.value1,true);
		ajax.send(null);
	}else{
		ajax.open(json.method,json.url,true);
		ajax.setRequestHeader("content-Type","application/x-www-form-urlencoded");
		ajax.send("value="+json.value1);
	}
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&&ajax.status==200){
			json.success(ajax.responseText);
		}
	}
}
function  createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
	 return ajax;
}
function a(){
	this.a=6;
	this.b=function(){
		alert("7");
	}
	   
}
a.prototype.getName=function(){
	alert(1);
}
function a1(){
}
a1.prototype=a.prototype;
var q=new a1();
alert("a1=="+q.a);
var s=new a();
alert("a="+s.a);
s.b();
s.getName();
var s1=new a();
s1.getName();
s1.a=2;
alert("s1.a==="+s1.a);



