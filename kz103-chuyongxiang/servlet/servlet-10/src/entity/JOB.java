package entity;

public class JOB {
	private String name;

	public JOB(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "JOB [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JOB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
