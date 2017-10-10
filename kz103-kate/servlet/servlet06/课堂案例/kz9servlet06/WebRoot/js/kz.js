var ajax;
function pickCity(obj){
	//alert(obj.value);
	//alert(document.getElementById("province").value);
	//alert(1);
	//1,�õ�ajax����XMLHTTPRequest�����0)�õ��绰
	createAjax();
	//2,����ajax��������첽����
	//1)��
	var method = "get";//�ύ��ʽ
	var url = "CityServlet?pid="+obj.value+"&"+Math.random();//�������Դ��url
	ajax.open(method,url,true);//true���첽����
	//2)��
	ajax.send(null);
	//3)��
	ajax.onreadystatechange=callback;//���ûص�����
	
}

function pickCityPost(obj){
	//alert(obj.value);
	//alert(document.getElementById("province").value);
	//alert(1);
	//1,�õ�ajax����XMLHTTPRequest�����0)�õ��绰
	createAjax();
	//2,����ajax��������첽����
	//1)��
	var method = "post";//�ύ��ʽ
	var url = "CityServlet";//�������Դ��url
	ajax.open(method,url,true);//true���첽����
	ajax.setRequestHeader("content-Type","application/x-www-form-urlencoded");
	//2)��
	ajax.send("pid="+obj.value+"&"+Math.random());
	//3)��
	ajax.onreadystatechange=callback;//���ûص�����
	
}
function callback(){//ͨ��
	//״̬��ajax״̬��4   http״̬��200
	//alert(ajax.readyState+"---"+ajax.status);
	if(ajax.readyState==4&&ajax.status==200){
		//1,�����ı���ajax.responseText
		//2,����xml�ı�:ajax.responseXml
		//alert(ajax.responseXML);
		var xmlObj = ajax.responseXML;
		/*
		 * 
		 * 
		 * <citys>
		 * 	<city id='1'>
		 * 		<name>̫ԭ��</name>
		 * 	</city>
		 * 	<city id='2'>
		 * 		<name>��ͬ��</name>
		 * 	</city>
		 * <city id='3'>
		 * 		<name>��Ȫ��</name>
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
	 //�ж�������İ汾:IE7������ FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
}