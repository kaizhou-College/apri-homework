//�ص�����
function add(a,b){
	return a()+b();
}
//���������ص�
//alert(add(function(){return 1;},function(){return 2;}))
//����
function aa(){
	return 1;
}
function bb(){
	return 2;
}
alert(add(aa,bb));

//��װ:ajax   �õ�ajax����(���ֻ�)--�������ӣ�����--�������󣨴�--������Ӧ���ӣ�
function  createAjax(){
	 //�ж�������İ汾:IE7������ FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
	 return ajax;
}
//��װһ��kzAjax�ķ���----��������
//function kzAjax2(method,url,callback){
//	//1,�õ�ajax����
//	var ajax = createAjax();
//	//2,��������
//	ajax.open(method,url,true);
//	//3,��������
//	ajax.send(null);
//	//4,������Ӧ(��ͬ����Ŀ����Ӧ�Ĵ���ͬ)
//	ajax.onreadystatechange=function(){
//		if(ajax.readyState==4&ajax.status==200){
//			//������������
//			callback(ajax.responseText);
//		}
//	}
//}
//
//function kzAjax(json){
//	//1,�õ�ajax����
//	var ajax = createAjax();
//	//2,��������
//	ajax.open(json.method,json.url,true);
//	//3,��������
//	ajax.send(null);
//	//4,������Ӧ(��ͬ����Ŀ����Ӧ�Ĵ���ͬ)
//	ajax.onreadystatechange=function(){
//		if(ajax.readyState==4&ajax.status==200){
//			//������������
//			//callback(ajax.responseText);
//			json.success(ajax.responseText);
//		}
//	}
//}




