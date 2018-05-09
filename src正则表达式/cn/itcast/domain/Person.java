package cn.itcast.domain;

public class Person {

	private String name;
	private int age;
	public Person() {
		super();
		System.out.println("person run");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public void show(String name,int age){
		
		System.out.println("show run...name="+name+",age="+age);
	}
	
	public static void staticShow(){
		System.out.println("static show run");
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
