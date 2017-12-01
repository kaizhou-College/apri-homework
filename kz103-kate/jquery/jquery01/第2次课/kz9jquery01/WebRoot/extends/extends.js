//继承
//function Person(name){
//	this.name = name;
//}
//Person.prototype.name="二狗子";
//Person.prototype.getName=function(){
//	alert(this.name);
//}
//Student.prototype=Person.prototype
//function Student(){
//	
//}
//var s = new Student();
//s.name="二娃子";
//s.getName();

//追加原型方法 -----jQuery
function kzextends(json,parent){
	function F(){}
	if(typeof parent =="function" ){
		F.prototype = parent.prototype;
	}
	if(typeof json == "object"){
			for(var key in json){
				F.prototype[key] = json[key];
			}
	}
	return F.prototype;
}
function Person(){}
function Student(){}

//extends Person
Student.prototype=kzextends({"name":"二狗子","age":12},Person);
var s = new Student();
//alert(s.name);
//alert(s.age);


function BigStudent(){
	
} 
BigStudent.prototype = kzextends({"sex":"男","getAge":function(){alert(this.age)}},Student);
var bs = new BigStudent();
alert(bs.name);
alert(bs.age);
alert(bs.sex);
bs.getAge();




