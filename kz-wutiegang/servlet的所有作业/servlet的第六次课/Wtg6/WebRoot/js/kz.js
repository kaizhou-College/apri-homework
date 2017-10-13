var ajax;
function pickCityPost(obj){
	
	//1.得到ajax
	Ajax();
	var method="get";
	var url="CityServlet?pid="+obj.value+"&"+Math.random();//请求的资源的url
	ajax.open(method,url,true);//true是异步请求
	//2.打
	ajax.send(null);
	//3.接
	ajax.onreadystatechange=cp;//设置回调函数
}
function cp(){
	if(ajax.readyState==4&&ajax.status==200){
		var xmlObj=ajax.responseXML;
		var cityNodes=xmlObj.getElementsByTagName("city");
		var city=document.getElementById("city");
		city.options.length=1;
		for(var i=0;i<cityNodes.length;i++){
			var id=cityNodes[i].getAttribute("id");
			var name=cityNodes[i].childNodes[0].childNodes[0].nodeValue;
			var opt=new Option(name,id);
			city.add(opt);
		}
	}
	
}
function Ajax(){
	//判断浏览器的版本：ie7或以上
	if(window.XMLHttpRequest){
		ajax =new XMLHttpRequest();
	}else{
		ajax=new ActiveXObject("Microsoft.XMLHTTP");
	}
}