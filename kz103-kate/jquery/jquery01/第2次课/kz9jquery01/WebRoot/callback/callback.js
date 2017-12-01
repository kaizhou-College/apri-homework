//回调函数
function add(a,b){
	return a()+b();
}
//匿名函数回调
//alert(add(function(){return 1;},function(){return 2;}))
//函数
function aa(){
	return 1;
}
function bb(){
	return 2;
}
alert(add(aa,bb));

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
//function kzAjax2(method,url,callback){
//	//1,得到ajax对象
//	var ajax = createAjax();
//	//2,建立连接
//	ajax.open(method,url,true);
//	//3,发送请求
//	ajax.send(null);
//	//4,处理响应(不同的项目对响应的处理不同)
//	ajax.onreadystatechange=function(){
//		if(ajax.readyState==4&ajax.status==200){
//			//处理结果？？？
//			callback(ajax.responseText);
//		}
//	}
//}
//
//function kzAjax(json){
//	//1,得到ajax对象
//	var ajax = createAjax();
//	//2,建立连接
//	ajax.open(json.method,json.url,true);
//	//3,发送请求
//	ajax.send(null);
//	//4,处理响应(不同的项目对响应的处理不同)
//	ajax.onreadystatechange=function(){
//		if(ajax.readyState==4&ajax.status==200){
//			//处理结果？？？
//			//callback(ajax.responseText);
//			json.success(ajax.responseText);
//		}
//	}
//}




