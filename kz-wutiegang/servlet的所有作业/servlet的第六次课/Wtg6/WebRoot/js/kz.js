var ajax;
function pickCityPost(obj){
	
	//1.�õ�ajax
	Ajax();
	var method="get";
	var url="CityServlet?pid="+obj.value+"&"+Math.random();//�������Դ��url
	ajax.open(method,url,true);//true���첽����
	//2.��
	ajax.send(null);
	//3.��
	ajax.onreadystatechange=cp;//���ûص�����
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
	//�ж�������İ汾��ie7������
	if(window.XMLHttpRequest){
		ajax =new XMLHttpRequest();
	}else{
		ajax=new ActiveXObject("Microsoft.XMLHTTP");
	}
}