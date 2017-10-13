package entity;

public class cloneTest01 implements Cloneable{
	private String name;
	private cloneTest02 clone;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "cloneTest01 [name=" + name + "]";
	}

	public cloneTest01() {
		super();
	}
	
	public cloneTest02 getClone() {
		return clone;
	}

	public void setClone(cloneTest02 clone) {
		this.clone = clone;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		cloneTest01 c = (cloneTest01) super.clone();
		cloneTest02 c2 = (cloneTest02) this.clone.clone();
		return super.clone();
	}
}
