package entity;

public class Look implements Cloneable{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
