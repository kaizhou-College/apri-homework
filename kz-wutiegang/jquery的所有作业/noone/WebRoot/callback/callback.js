function  createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
	 return ajax;
}
/*function kzAjax(method,url,callback){
	var ajax=createAjax();
	ajax.open(method,url,true);
	ajax.send(null);
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&ajax.status==200){
			callback(ajax.responseText);
		}
	}
}*/
function kzAjax(json){
	var ajax=createAjax();
	//如果提交方式为post
	if(json.method=="post"){
		ajax.open(json.method,json.url,true);
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		
		ajax.send("json="+json.data);
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4&ajax.status==200){
				json.success(ajax.responseText);
			}
		}
	}
	//如果提交方式为get
	if(json.method=="get"){
		ajax.open(json.method,json.url+"?json="+json,true);
		ajax.send(null);
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4&ajax.status==200){
				json.success(ajax.responseText);
			}		
		}
	}
}
