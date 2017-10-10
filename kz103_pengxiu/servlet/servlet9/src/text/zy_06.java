package text;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import entity.dog;

public class zy_06 {
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		URL url=new URL("http://localhost:8080/entity/test.jar");
		URL[] urls=new URL[]{url};
		URLClassLoader loader=new URLClassLoader(urls);
		Class c= loader.loadClass("entity.dog");
		System.out.println(c.getName());
		dog dog=(dog)c.newInstance();
	}

	
}
