package cn.itcast.reflect.demo;

import java.lang.reflect.Constructor;

public class Reflect_GetConstructor {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * 如果要通过指定的构造函数初始化对象怎么办呢？
		 * 思路：
		 * 1，获取字节码文件对象。
		 * 2，再获取给定的构造函数。
		 * 3，通过构造函数初始化对象。
		 * 
		 */
		
		getConstructorDemo();
	}

	public static void getConstructorDemo() throws Exception {
		
		String className = "cn.itcast.domain.Person";
		Class clazz = Class.forName(className);
		
		//获取指定的构造器。获取Person类中两个参数string,int的构造函数。
		Constructor cons = clazz.getConstructor(String.class,int.class);
		
		//有了构造器对象后，通过构造器对象来初始化给类对象。
		Object obj = cons.newInstance("wangwu",23);
		//Person p = new Person("lisi",21);
		
		
		System.out.println(obj);
		
	}

}
