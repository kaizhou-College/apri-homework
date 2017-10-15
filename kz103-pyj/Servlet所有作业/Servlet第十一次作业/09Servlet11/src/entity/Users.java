package entity;

public class Users {
	private int id;
	private String name;
	private int age;
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
	public Users() {
		super();
	}
	public Users(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
}
