function kzextends(json,parent){
	function F(){}
	if( typeof parent=="function"){
		F.prototype=parent.prototype;
	}
	if(typeof json =="object"){
		for(var key in json){
			F.prototype[key]=json[key];
		}
	}
	return F.prototype;
}


function Person(){
	
	
}

function Student(){
	
	
	
}

Student.prototype=kzextends({"name":"二狗子","age":12},Person)

var s = new Student();
alert(s.name);
alert(s.age);


