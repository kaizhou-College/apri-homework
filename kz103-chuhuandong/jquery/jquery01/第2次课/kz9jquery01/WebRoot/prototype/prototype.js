/*
 *prototype:ԭ����
 *1��javaScript��������js��û��{}������ ֻ�к��������� 
 * 	�ܽ᣺�ں����ڲ�����ı������ߺ�������˽�е�ֻ���ں����ڲ�����ʹ�ã���
 *2��js�ľ�̬���Ժͷ���
 * 	1��function��������һ������������һ������ͬʱ����һ�����췽��
 *  2����̬����ֻ��ͨ�������������з��ʣ�ͨ��������new���Ķ����ǲ��ܷ��ʵģ�
 */
//��1��js������
//if(1<2){
//	//ȫ��
//	var a = 34;//
//}
//alert(a);
//function student(){
//	//˽��
//	var b = 56;
//	var getName= function(){
//		alert("def");
//	}
//}
//alert(this.b);
//��2,js�ľ�̬���Ժͷ��� :��
//function Student(){//��
//	
//}
//Student.age = 12;
//Student.getAge = function(){
//	alert(this.age);	
//}
//var s = new Student();//����
//alert(s.age); //undefined
//alert(Student.age);//12
//��3��ʵ������ :����ͨ��������ֱ�ӵ��ã�����ͨ��ʵ�����е��á�
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

//�����ʣ������м���age���� �ͼ���getAge()����????  2��
//�����⣺��һ�������ڲ����ܶ����ǧ�����������ÿ��new�����Ҫ
//�����Ժͷ���������һ���ݣ����ǲ�Ը�⿴���ģ�����
//����ô������� prototypeԭ����
//var s1 = new Student();
//s1.age=14;
//alert(s1.age);
//s1.getAge();
//��prototype��ʲô��prototype��һ������ prototype=Student{} ����Student������ԭ�Ͷ���
//�ܽ᣺ ��һ������ȡ����һ�����Ի��߷����������ڶ����Լ������ң��ҵ��ͷ��أ����߾͵�������
//ԭ����(prototype)�ϲ��ң��ҵ��ͷ��أ����߼�����ԭ������ԭ����....�����ң��ҵ��ͷ��أ����߲�����
function Student(){	
	this.name = "abc";
	
}
//��ԭ�������һ������ getName
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





