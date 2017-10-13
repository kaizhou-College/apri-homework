package entity;

public class A {
	public int aid=1;
	public String name;
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	public A(int aid, String name) {
		super();
		this.aid = aid;
		this.name = name;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "A [aid=" + aid + ", name=" + name + "]";
	}
	
}
