
//封装:ajax   得到ajax对象(得手机)--建立连接（拨）--发送请求（打）--接受响应（接）
function  createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
	 return ajax;
}
//封装一个kzAjax的方法----不够优雅
function Ajax1(method,url,arr,callback){
	//1,得到ajax对象
	var ajax = createAjax();
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
			//2,建立连接
			ajax.open(method,url+"?"+str,true);
			//3,发送请求
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
			alert(url+"?"+str);
			//2,建立连接
			ajax.open(method,url,true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//3,发送请求
			ajax.send(str);
		}
	}
	
	
	//4,处理响应(不同的项目对响应的处理不同)
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&ajax.status==200){
			//处理结果
			alert(ajax.responseText)
			json.callback(ajax.responseText);
		}
	}
}

//json方法
function Ajax2(json){
	//1,得到ajax对象
	var ajax = createAjax();
	if(json.method=="get"){
		var str="";
		if(json.arr!=null){
			for(var i=0;i<json.arr.length;i++){
				if(str.length==0){
					str=str+json.arr[i];
				}else{
					str=str+","+json.arr[i];
				}
			}
			alert(json.url+"?"+str);
			//2,建立连接
			ajax.open(json.method,json.url+"?"+str,true);
			//3,发送请求
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
			alert(json.url+"?"+str);
			//2,建立连接
			ajax.open(json.method,json.url,true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//3,发送请求
			ajax.send(str);
		}
	}
	
	
	//4,处理响应(不同的项目对响应的处理不同)
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&ajax.status==200){
			//处理结果
			alert(ajax.responseText)
			json.callback(ajax.responseText);
		}
	}
}




