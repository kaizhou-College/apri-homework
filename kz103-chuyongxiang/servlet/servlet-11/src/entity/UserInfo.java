package entity;

public class UserInfo {
	private int id;
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Users [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
}
