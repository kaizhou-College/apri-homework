var ajax;
function pickCity(obj){
	//alert(obj.value);
	//alert(document.getElementById("province").value);
	//alert(1);
	//1,得到ajax对象：XMLHTTPRequest类对象0)得到电话
	createAjax();
	//2,调用ajax对象进行异步请求
	//1)拨
	var method = "get";//提交方式
	var url = "CityServlet?pid="+obj.value+"&"+Math.random();//请求的资源的url
	ajax.open(method,url,true);//true是异步请求
	//2)打
	ajax.send(null);
	//3)接
	ajax.onreadystatechange=callback;//设置回调函数
	
}

function pickCityPost(obj){
	//alert(obj.value);
	//alert(document.getElementById("province").value);
	//alert(1);
	//1,得到ajax对象：XMLHTTPRequest类对象0)得到电话
	createAjax();
	//2,调用ajax对象进行异步请求
	//1)拨
	var method = "post";//提交方式
	var url = "CityServlet";//请求的资源的url
	ajax.open(method,url,true);//true是异步请求
	ajax.setRequestHeader("content-Type","application/x-www-form-urlencoded");
	//2)打
	ajax.send("pid="+obj.value+"&"+Math.random());
	//3)接
	ajax.onreadystatechange=callback;//设置回调函数
	
}
function callback(){//通话
	//状态：ajax状态：4   http状态：200
	//alert(ajax.readyState+"---"+ajax.status);
	if(ajax.readyState==4&&ajax.status==200){
		//1,接受文本：ajax.responseText
		//2,接受xml文本:ajax.responseXml
		//alert(ajax.responseXML);
		var xmlObj = ajax.responseXML;
		/*
		 * 
		 * 
		 * <citys>
		 * 	<city id='1'>
		 * 		<name>太原市</name>
		 * 	</city>
		 * 	<city id='2'>
		 * 		<name>大同市</name>
		 * 	</city>
		 * <city id='3'>
		 * 		<name>阳泉市</name>
		 * </city>
		 * </citys>

		 */
		var cityNodes = xmlObj.getElementsByTagName("city");
		var city = document.getElementById("city");
		city.options.length=1;
		for(var i = 0;i<cityNodes.length;i++){
			var  id= cityNodes[i].getAttribute("id");
			var name=cityNodes[i].childNodes[0].childNodes[0].nodeValue;
			var opt = new Option(name,id);
			city.add(opt);
		}
	}
	
}

function createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
}