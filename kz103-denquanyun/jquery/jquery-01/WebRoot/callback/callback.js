function creatAjax(){
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
	 return ajax;
}
function yyAjaxOne(method,url,arr,cb){//方法  路径  回调函数
	var ajax = creatAjax();
	if(method=="get"){
		var str="";
		if(arr!=null){
			for(var i=0;i<arr.length;i++){
				if(str.length==0){
					str=str+arr[i];
				}else{
					str=str+","+arr[i];
				}	
			}
			alert(url+"?"+str);
			ajax.open(method,url+"?"+str,true);
			alert("open");
			ajax.send(null);
		}
	}
	if(method=="post"){
		var str="";
		if(arr!=null){
			for(var i=0;i<arr.length;i++){
				if(str.length==0){
					str=str+arr[i];
				}else{
					str=str+"&"+arr[i];
				}	
			}
			alert(str);
			ajax.open(method,url,true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			ajax.send(str);
		}
	}
	ajax.onreadystatechange=function(){
		if(ajax.readyState ==4&&ajax.status==200){
			alert(ajax.responseText)
			cb(ajax.responseText);
		}
	};
}


function yyAjaxTwo(json){
	alert(json.method);
	var ajax = creatAjax();
	if(json.method=="get"){
		var str="";
		if(json.arr!=null){
			for(var i=0;i<json.arr.length;i++){
				alert(1);
				if(str.length==0){
					str=str+json.arr[i];
				}else{
					str=str+","+json.arr[i];
				}	
			}
			ajax.open(json.method,json.url+"?"+str,true);
			alert("open");
			ajax.send(null);
		}
	}
	if(json.method=="post"){
		var str="";
		if(json.arr!=null){
			for(var i=0;i<json.arr.length;i++){
				if(str.length==0){
					str=str+json.arr[i];
				}else{
					str=str+"&"+json.arr[i];
				}	
			}
			alert(str);
			ajax.open(json.method,json.url,true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			ajax.send(str);
		}
	}
	ajax.onreadystatechange=function(){
		if(ajax.readyState ==4&&ajax.status==200){
			alert(ajax.responseText)
			json.cb(ajax.responseText);
		}
	};
}

