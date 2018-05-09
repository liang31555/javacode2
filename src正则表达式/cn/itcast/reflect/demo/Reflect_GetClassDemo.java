package cn.itcast.reflect.demo;

import cn.itcast.domain.Person;

public class Reflect_GetClassDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		/*
		 * 要想获取字节码文件中的成员，必须要先获取字节码文件对象。
		 * 获取字节码文件对象的方式：
		 * 1，通过Object类中的getClass方法。
		 * 虽然通用，但是前提必须有指定类，并对该类进行对象的创建，才可以调用getClass方法。
		 * 2，使用的任意数据类的一个静态成员class，所有的数据类型都具备的一个属性。
		 * 好处：不用new对象。但是，还需要使用具体的类。
		 * 3，使用Class类中的forName方法。通过给定类名来获取对应的字节码文件对象。
		 * 这种方式很爽，只要知道类的名字就可以了。获取对应的字节码文件直接由forName方法自动完成。
		 * 这就是反射技术使用的获取字节码文件对象的方式。
		 */
		
		getClass_3();
	}

	public static void getClass_3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String className = "cn.itcast.domain.Person";
		
		/*
		 * 1，通过给定的类名称，加载对应的字节码文件，并封装成字节码文件对象Class.
		 */
		Class clazz = Class.forName(className);
//		System.out.println(clazz);
		
		//通过newInstance()就可以创建字节码对象所表示的类的实例。
		/*
		 * 2，通过new创建给定的类的实例。
		 * 3，调用该类的构造函数。
		 * 通常被反射的类都会有提供空参数的构造函数。
		 * 没有对应的构造函数，会报InstantiationException
		 * 如果有提供，但是权限不够，会报IllegalAccessException
		 * 
		 */
		Object obj = clazz.newInstance();
		
		
		/* Person p = new Person();
		 * 1，加载Person类，并将Person类封装成字节码文件对象。
		 * 2，通过new创建Person对象。
		 * 3，调用构造函数对对象初始化。
		 */
		System.out.println(obj);
		
	}

	public static void getClass_2() {
		
		Class clazz = Person.class;
	}

	public static void getClass_1() {
	
		Person p1 = new Person();
		Person p2 = new Person();
		Class clazz1 = p1.getClass();
		Class clazz2 = p2.getClass();
		System.out.println(clazz1 == clazz2);//true

//		System.out.println(clazz1.getName());//获取类的名字。
	}
}
