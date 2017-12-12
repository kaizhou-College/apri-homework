function Student(){
	alert(this);
}
Student();
function smallStudent(){
	this.a=Student;
}

var small=new smallStudent();
small.a();
var json={
	"bb":Student
}
json.bb();
Student.apply(smallStudent());
Student.call(json);