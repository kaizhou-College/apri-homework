package work05.entity;

public class Role {
	private String id ;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id2) {
		this.id = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[id=="+id+"		name==="+name+"]";
	}
}
