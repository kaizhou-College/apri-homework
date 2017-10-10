package com.kz.test;
//为什么在java虚拟机中需要3个类加载器？
public class Test4 {
	public static void main(String[] args) throws ClassNotFoundException {
		//1, 系统加载器：sun.misc.Launcher$AppClassLoader@1372a1a
		//系统加载器是加载：工程中的classes文件夹下的clas是文件
		//如果工程中没有加载到就会到 jdk的classpath的路径下去查找
		Class c1 = Class.forName("com.kz.entity.Man");
		ClassLoader cl1 = c1.getClassLoader();
		System.out.println(cl1);
		
		//2,扩展加载器：JDK_HOME/jre/lib/ext下加载class
		//Class ext = Class.forName("sun.security.mscapi.Key");
		//Class ext = Class.forName("com.kz.entity.Pig");
		//System.out.println(ext.getClassLoader());
		
		//3,根加载器: jdk核心包 lib下的包 rt.jar tool.jar
		//Class root = Class.forName("java.lang.Object");
		//System.out.println(root.getClassLoader());
	
		//三大原则：
		//1,委托加载机制
		//当虚拟机接收到类加载请求的时候，首先调用app加载器，但是不会马上加载
		//app类加载器先要委托ext加载器加载，ext类加载器也不会先加载，会委托根加载器
		//加载,如果根加载器加载不到，才到ext加载器加载，ext加载器加载不到再到app加载器
		//加载，app加载器就会报错：ClassNotFoundException异常
		//2,一致性原则
		//只要有一个加载器加载到了类，那么其他加载就不会再加载了，
		//保证加载的类的一致性
		
		//3,透明性原则：
		//底层加载器，可以看到顶层加载器加载的内容。
		//我们的程序能使用java的核心api(Object)
		
		
		
	
	}
}
