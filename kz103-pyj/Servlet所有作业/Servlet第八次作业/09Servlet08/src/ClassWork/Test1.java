package ClassWork;
/*在d: 写一个Test1类，在main方法中调用在e盘的Test2类的一个方法，
然后在各java程序所在的盘符下编译完成以后，
在c盘使用java 命令运行:java Test.java
前提在环境变量中设置  classpath=".;d:\;e:\"*/
public class Test1 {
	public static void main(String[] args) {
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		try {
			Class clazz=cl.loadClass("Test2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
