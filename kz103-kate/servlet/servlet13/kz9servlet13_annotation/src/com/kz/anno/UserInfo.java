package com.kz.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
//ִ��ע����Ϣ�Ƿ�����class�ļ����Ƿ������ �Ƿ�ɻ�ȡ
@Retention(RetentionPolicy.RUNTIME)
//ע��ʹ�õĵط�(��)
@Target(ElementType.TYPE)
/*public @interface UserInfo {
	//����----defaultĬ��ֵ
	String username() default "������"; //��ʾUserInfoע����һ��username������
	String passward();
}*/
public @interface UserInfo {
	//����----defaultĬ��ֵ
	String username() default "������"; //��ʾUserInfoע����һ��username������
	String value();
}
