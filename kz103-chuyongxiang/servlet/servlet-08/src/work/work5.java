package work;

public class work5 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class clazz = loader.loadClass("Test2");
	}
}
