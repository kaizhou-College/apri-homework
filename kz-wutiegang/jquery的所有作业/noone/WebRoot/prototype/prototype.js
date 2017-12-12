
/*prototype:原型链
 * 
 * 
 * 
 */
//function Student(){
//	this.name="二狗子";
//}
//var s=new Student();
//alert(s.name);
//function Student(){
//}
//Student.name1="狗子";
//Student.getName=function(){
//	alert("222");
//}
//alert(Student.getName);
function Student(){
	this.name1="某某某";
}
Student.prototype.getName=function(){
	alert(this.name1+"1");
}
Student.age=2;
Student.getName=function(){
	alert(this.name1+"2");
}
var s=new Student();
s.getName=function(){
	alert("111");
}
s.getName();
var s1=new Student();
s1.getName();
Student.getName();