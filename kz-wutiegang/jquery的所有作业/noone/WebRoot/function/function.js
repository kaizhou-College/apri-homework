//【1】直接new对象
//var obj=new Object();
//alert(obj.constructor);
//obj.age=12;
//obj.name="二狗子";
//alert(obj.age);
//obj.getName=function(){
//	alert(obj.name);
//}
//obj.getName();
//【2】json对象
//var men={
//	"age":12,
//	"getName":function(name){
//		alert(name);
//	}
//}
//alert(men.age);
//men.getName("张三");
//men.name="李四";
//men.getName=function(){
//	alert(men.name);
//}
//alert(men.name);
//men.getName();
//【3】function表示一个对象，一个函数
//function a(){
//	alert("111");
//}
//a();
//a.age=2;
//a.getName=function(name){
//	alert(name);
//}
//alert(a.age);
//a.getName("王五");
//【4】定义命名空间
//[1]如果是同一个函数名，那么前一个函数值就会被覆盖
//var a=function(){
//	alert("111");
//}
//var a=function(){
//	alert("222");
//}
//a();
//[2]
function namespace(namespace){
	//把字符串用.号截取成一个数组
	var num=[];
	var namearr=namespace.split(".");//用.号截取之后就是对应的几个函数
	for(var i=0;i<namearr.length;i++){
		num.push(namearr[i]);
		eval("window."+num.join(".")+"=function(){}");
	}
}
namespace("com.kz.wtg");
getName=function(){
	alert("111");
}
com.kz.wtg.getName=function(){
	alert("222");
}
getName();
com.kz.wtg.getName();


