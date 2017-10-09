package Entity;

public class Books {
	private String name;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Books(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Books() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + "]";
	}

	
}
