package entity;



/**
 * Wife entity. @author MyEclipse Persistence Tools
 */

public class Wife  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Husband husband;


    // Constructors

    /** default constructor */
    public Wife() {
    }

    
    /** full constructor */
    public Wife(Long id, String name) {
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


	public Husband getHusband() {
		return husband;
	}


	public void setHusband(Husband husband) {
		this.husband = husband;
	}


	@Override
	public String toString() {
		return "Wife [ id=" + id + ", name=" + name
				+ "]";
	}
   








}