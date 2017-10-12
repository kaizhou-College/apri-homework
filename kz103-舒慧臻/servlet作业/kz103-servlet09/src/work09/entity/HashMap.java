package work09.entity;

public class HashMap {
	private int age;
	private String name;
	
	static{
		System.out.println("静态块");
	}
	
	{
		System.out.println("对象块");
	}
	
	public HashMap(){
		System.out.println("HashMap生成了一个对象");
	}
	
	public void sayHello(){
		System.out.println("有名块		say Hello");
	}
	

}
