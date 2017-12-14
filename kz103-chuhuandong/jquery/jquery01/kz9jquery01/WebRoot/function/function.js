/*
 *js中创建对象的集中方式
 * 1，new 方式
 * 2,json对象
 * 3,function  即是一个函数 也是一个对象
 * 
 * 总结：动态添加属性和方法
 */
//【1，new 方式】
//var obj = new Object();
////0>>构造函数
////alert(obj.constructor);
////1>>动态添加属性
//obj.age = 4;
//alert(obj.age);
////2>>动态添加方法
//obj.a = function(args){alert("我是方法"+args)}
////=====>
////function a(){}
//obj.a("abc");
//【2,json对象:key--value:key一般都加"" ,值是非数字也加""】
//var student = {
//	"age":23,
//	"getName":function(){
//		alert("abc");
//	}
//}
//alert(student.age)
//student.getName();
////动态添加属性和方法
//student.name="二狗子";
//student.getName = function(){
//	alert(this.name)
//}
//alert(student.name);
//student.getName();
//【3,function:function表示一个方法,也是一个对象】
//function a(){
//	alert("abc");
//}
////a();
////动态的添加属性和方法
//a.age = 32;
//a.getName=function(){
//	alert("def");
//}
//alert(a.age);
//a.getName();

//动态添加属性和方法的特征：定义命名空间
//function com(){
//	alert("A");
//}
//function test(){
//	alert("B");
//}
//com.kz =test;
//
//com.kz();
//com.xdf.getName = function(){
//	alert("def");
//}
//getName =function(){
//	alert("abc");
//}
//getName();//window.getName();
//com.kz.getName();


//var getName = function(){
//	alert("abc");
//} 
//var getName = function(){
//	alert("def");
//}
//getName();
function namespace(nameSpaceStr){
	var temp = [];
	var nameArr = nameSpaceStr.split(".");//[com,kz,test]
	for(var i=0;i<nameArr.length;i++){
		//将com,kz，test一个个取出来放入新的数组
		temp.push(nameArr[i]);
		//然后拼接成[com,kz]  ==join(".")==>"com.kz"
		eval("window."+temp.join(".")+"=function (){}");
	}
}
namespace("com.kz.test");
com.sdj.nb.getName=function(){
	alert("abc");
}
getName=function(){
	alert("def");
}
getName();
com.kz.test.getName();

//
//window.com = function(){
//	
//}
//com.kz= function (){
//	
//}
//com.kz.test = function (){
//	
//}
//com.kz.test.getAge = function (){
//	alert(123);
//}
//com.kz.test.getAge();













