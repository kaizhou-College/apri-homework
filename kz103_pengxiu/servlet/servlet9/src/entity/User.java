package entity;

public class User {
	static{
		System.out.println("静态板块");
	}
	{
		System.out.println("对象块");
	}
	public User() {
		System.out.println("User出生了");
	}
	public  void asyHello(){
		System.out.println("有名字的板块");
	}
}
