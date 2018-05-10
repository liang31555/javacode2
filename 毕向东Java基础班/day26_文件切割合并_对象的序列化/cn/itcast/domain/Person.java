﻿package cn.itcast.domain;

import java.io.Serializable;

/*
 * 序列化接口的作用：没有方法，不需要覆盖，是一个标记接口为了启动一个序列化功能。
 * 唯一作用，给每一个需要序列化的类都分配一个序列版本号。
 * 这个版本号和该类相关联。
 * 这个版本号有什么用呢？
 * 在序列化时，会将这个序列号也异同保存到文件中。
 * 在反序列化会读取这个序列化和本类的序列化进行匹配，如果不匹配会抛出异常。java.io.InvalidClassException
 * 哦，原来是用于验证的。
 * 
 * 那我们在序列化时，显示定义吗？
 * 
 * 
 */


public class Person implements Serializable /*标记接口，用于启动类的序列化功能*/{
	
	
	private static final long serialVersionUID = 1234567L;
	private static String name;// 静态数据是不会被序列化。
	private transient/*瞬态*/ int age;//对于一个非静态的数据也不想序列化咋办？需要一个关键字来修饰。transient
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
