//匿名函数自调用格式：(function(){})()

(function(){
	//写一个函数返回两个属性
	function F(){
		return{
			getName:getName,
			setName:setName
		}
	}
	function a(){}
	function b(){}
	function getName(){
		return this.name;
	}
	function setName(name){
		this.name=name;
	}
	window.F=F;
	
})(window);
var Student=window.F();
Student.setName("功夫小子");
alert(Student.getName());




	

