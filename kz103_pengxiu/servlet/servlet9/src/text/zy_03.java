package text;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class zy_03 {
	public static void main(String[] args) {
		Class c=Hashtable.class;
		while(c!=null){
			System.out.println(c.getName());
			c=c.getSuperclass();//Í£Ö¹Ìõ¼þ
		}
	}
	
}
