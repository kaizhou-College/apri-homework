package ClassWork;

public class Work3 {
	public static void main(String[] args) {
		Class c=Work3.class;
		while(c!=null){
			System.out.println(c.getName());
			c=c.getSuperclass();
		}
	}


}
