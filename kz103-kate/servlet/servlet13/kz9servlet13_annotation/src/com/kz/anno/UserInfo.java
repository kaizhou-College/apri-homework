package com.kz.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
//执行注解信息是否编译进class文件，是否可运行 是否可获取
@Retention(RetentionPolicy.RUNTIME)
//注解使用的地方(类)
@Target(ElementType.TYPE)
/*public @interface UserInfo {
	//属性----default默认值
	String username() default "二狗子"; //表示UserInfo注解有一个username的属性
	String passward();
}*/
public @interface UserInfo {
	//属性----default默认值
	String username() default "二狗子"; //表示UserInfo注解有一个username的属性
	String value();
}
