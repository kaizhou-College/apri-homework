//复习prototype原型链
//function Student(name){
//	this.name = name;
//}
////alert(typeof Student.prototype);
//alert(typeof Student.constructor);
////alert(typeof Student);
//Student.prototype.age=12;//普通属性
//Student.prototype.getAge=function(){
//	alert(this.age);
//}
//Student.prototype.aa = [];//引用属性
//var s = new Student("二狗子");
//s.aa.push(1);
//alert(s.name);//(没有)"二狗子"
//alert(s.age);//12
//s.getAge();//12
//
//
//var s2 = new Student("三狗子");
//s2.aa.push(2);
//s2.age=13;
//alert("s.age=="+s.age);//12  13
//alert(s2.aa);
//
//alert(s.age);
//alert(s2.age);

//总结：原型方法和原型引用属性会被所有对象共享，原型的普通属性不会被共享
//=======================================================
//【javaScript :this  1）谁调用指向谁  2,)可以改变this执向】
//(java:this---当前类对象[谁调用，this指向的就是谁])
function Person(){
	alert(this);
}
Person();//this====window

function Student(){
	this.a=Person;//实例属性
}
var s = new Student();//a必须是静态属性
s.a();//===>s.Person();//this====s

Student.b = Person;
Student.b();//this====Student

var json ={
	bb:Person
}
json.bb();//this====json

//可以改变this执行
Person.call(Student); //==Student.Person();
Person.apply(json);//json.Person();





