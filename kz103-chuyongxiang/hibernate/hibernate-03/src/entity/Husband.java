package entity;

/**
 * Husband entity. @author MyEclipse Persistence Tools
 */

public class Husband implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Wife wife;

	// Constructors

	/** default constructor */
	public Husband() {
	}

	/** full constructor */
	public Husband(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband [id=" + id + ", name=" + name + "]";
	}
	

}