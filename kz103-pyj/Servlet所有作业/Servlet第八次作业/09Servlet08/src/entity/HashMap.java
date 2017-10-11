package entity;
//通过4种方式得到HashMap的Class对象
public class HashMap {
	private String name;
	static{
		System.out.println("HashMap静态块");
	}
	
	{
		System.out.println("HashMap对象块");
	}
	public HashMap(){
		System.out.println("HashMap出生");
	}
	
	public void HashMap(){
		System.out.println("hi i'm HashMap");
	}
}
