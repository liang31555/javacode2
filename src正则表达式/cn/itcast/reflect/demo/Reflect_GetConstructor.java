package cn.itcast.reflect.demo;

import java.lang.reflect.Constructor;

public class Reflect_GetConstructor {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * ���Ҫͨ��ָ���Ĺ��캯����ʼ��������ô���أ�
		 * ˼·��
		 * 1����ȡ�ֽ����ļ�����
		 * 2���ٻ�ȡ�����Ĺ��캯����
		 * 3��ͨ�����캯����ʼ������
		 * 
		 */
		
		getConstructorDemo();
	}

	public static void getConstructorDemo() throws Exception {
		
		String className = "cn.itcast.domain.Person";
		Class clazz = Class.forName(className);
		
		//��ȡָ���Ĺ���������ȡPerson������������string,int�Ĺ��캯����
		Constructor cons = clazz.getConstructor(String.class,int.class);
		
		//���˹����������ͨ����������������ʼ���������
		Object obj = cons.newInstance("wangwu",23);
		//Person p = new Person("lisi",21);
		
		
		System.out.println(obj);
		
	}

}
