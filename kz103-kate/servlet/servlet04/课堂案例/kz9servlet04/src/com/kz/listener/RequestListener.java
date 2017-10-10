package com.kz.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*监听request对象的监听器(秘书)
 * request对象生命周期：当每次接收请求的时候创建，请求结束时候就销毁。一次请求，一个request
 * 1，定义监听器
 * 2，配置
 * 
 * */
public class RequestListener implements ServletRequestListener{
	public RequestListener(){
		System.out.println("RequestListener出生了");
	}
	//当request对象销毁的时候，就会调用该方法，参数包含了监听事件的所有信息
	//web容器销毁request对象的时候，将事件封装成一个ServletRequestEvent类的对象
	//传递给request监听器的方法
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request对象被销毁了....");
		
	}
	//当request对象创建的时候，就会调用该方法
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request对象被创建了....");
	}
	
}
