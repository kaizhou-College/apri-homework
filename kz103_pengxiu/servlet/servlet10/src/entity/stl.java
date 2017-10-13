package entity;

public class stl {
	public String name;
	public String Sec;
	public stl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stl(String name, String sec) {
		super();
		this.name = name;
		Sec = sec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSec() {
		return Sec;
	}
	public void setSec(String sec) {
		Sec = sec;
	}
	@Override
	public String toString() {
		return "stl [Sec=" + Sec + ", name=" + name + "]";
	}
	
}
