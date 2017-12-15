/**
 * 闭包：函数外部要调用函数内部的变量和函数！！
 * 	1，匿名函数
 *  2，实现继承
 * 
 * java：类：封装（1，安全  2，数据的有效）
 */
(function(){
	//alert(11);
	function F(){
		return {
			getName:getName,
			setName:setName
		}
	}
	//私有方法
	function a(){
		
	}
	function b(){
		
	} 
	//公开的方法
	function getName(){
		return this.name;
	}
	function setName(name){
		this.name = name;
	}
	
	window.F = F;
})(window);//匿名函数自调用
var student = window.F();
student.setName("二狗子");
alert(student.getName());


//function s(){
//	var a = 3;
//	var getA = function(){
//		alert(this.a);
//	}
//}
//alert(s.a);//undefined
//var ss = new s();
//alert(ss.a);//undefined
//function getA(){
//	alert("abc");
//}