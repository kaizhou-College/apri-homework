function test1(){
	var name="hhh";
	var getname=function(){
		alert(this.name);
	}
}
test1.prototype.getname=function(){
	alert("emm");
}
var t = new test1();
alert(t.name);
t.getname();
