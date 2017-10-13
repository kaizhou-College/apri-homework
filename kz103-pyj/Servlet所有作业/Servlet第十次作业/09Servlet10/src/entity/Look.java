package entity;
/*写一个简单的例子，实现浅度克隆和深度克隆的例子*/
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
