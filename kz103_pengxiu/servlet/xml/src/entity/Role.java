package entity;

public class Role {
	private int id;
	private String name;
	private String birth;
	public Role(int id, String name, String birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Role [birth=" + birth + ", id=" + id + ", name=" + name + "]";
	}
	
	
}
