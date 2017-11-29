/*
 *prototype:原型链
 *1，javaScript的作用域：js中没有{}作用域 只有函数作用域 
 * 	总结：在函数内部定义的变量或者函数都是私有的只有在函数内部可以使用！！
 *2，js的静态属性和方法
 * 	1）function不仅仅是一个函数，还是一个对象，同时又是一个构造方法
 *  2）静态属性只能通过函数名来进行访问，通过函数名new出的对象是不能访问的！
 */
//【1，js作用域】
//if(1<2){
//	//全局
//	var a = 34;//
//}
//alert(a);
//function student(){
//	//私有
//	var b = 56;
//	var getName= function(){
//		alert("def");
//	}
//}
//alert(this.b);
//【2,js的静态属性和方法 :】
//function Student(){//类
//	
//}
//Student.age = 12;
//Student.getAge = function(){
//	alert(this.age);	
//}
//var s = new Student();//对象
//alert(s.age); //undefined
//alert(Student.age);//12
//【3，实例属性 :不能通过函数名直接调用，必须通过实例进行调用】
//function Student(){
//	this.age= 12;	
//	this.getAge = function(){
//		alert(this.age);
//	}
//}
//alert(Student.age);
//var s = new Student();
//s.age =13;
//alert(s.age);
//s.getAge();

//【请问：】在有几个age属性 和几个getAge()方法????  2个
//【问题：】一个函数内部可能定义成千上万个函数，每次new对象就要
//将属性和方法都复制一个份，这是不愿意看到的！！！
//【怎么解决？】 prototype原型链
//var s1 = new Student();
//s1.age=14;
//alert(s1.age);
//s1.getAge();
//【prototype是什么？prototype是一个对象 prototype=Student{} 叫做Student函数的原型对象】
//总结： 当一个对象取访问一个属性或者方法，首先在对象自己身上找，找到就返回，否者就到函数的
//原型链(prototype)上查找，找到就返回，否者继续找原型链的原型链....依次找，找到就返回，否者不返回
function Student(){	
	this.name = "abc";
	
}
//在原型上添加一个函数 getName
Student.prototype.getName = function(){
	alert(this.name+"2");
}
Student.getName = function(){
	alert(this.name+"1");
}
//alert(Student.prototype);
var s  = new Student();
s.getName();//abc1    abc2

var s1 = new Student();
s1.getName();





