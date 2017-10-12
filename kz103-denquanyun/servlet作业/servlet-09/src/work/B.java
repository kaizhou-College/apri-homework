package work;

public class B {
	public B(){
		System.out.println("调用默认构造方法");
	}

	public B(int a){
		System.out.println("调用B(int a)构造方法");
	}

	public B(Integer a){
		System.out.println("调用B(Integer a)构造方法");
	}
}
