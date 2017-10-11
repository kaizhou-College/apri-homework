package work;

import java.net.URL;
import java.net.URLClassLoader;


public class work6 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:127.0.0.1:8080/test/test.jar");
		URL[] urls = new URL[]{url};
		URLClassLoader loader = new URLClassLoader(urls);
		Class clazz = loader.loadClass("entity.Dog");
		System.out.println(clazz.toString());
	}
}
