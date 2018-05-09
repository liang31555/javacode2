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
		 * Ҫ���ȡ�ֽ����ļ��еĳ�Ա������Ҫ�Ȼ�ȡ�ֽ����ļ�����
		 * ��ȡ�ֽ����ļ�����ķ�ʽ��
		 * 1��ͨ��Object���е�getClass������
		 * ��Ȼͨ�ã�����ǰ�������ָ���࣬���Ը�����ж���Ĵ������ſ��Ե���getClass������
		 * 2��ʹ�õ������������һ����̬��Աclass�����е��������Ͷ��߱���һ�����ԡ�
		 * �ô�������new���󡣵��ǣ�����Ҫʹ�þ�����ࡣ
		 * 3��ʹ��Class���е�forName������ͨ��������������ȡ��Ӧ���ֽ����ļ�����
		 * ���ַ�ʽ��ˬ��ֻҪ֪��������־Ϳ����ˡ���ȡ��Ӧ���ֽ����ļ�ֱ����forName�����Զ���ɡ�
		 * ����Ƿ��似��ʹ�õĻ�ȡ�ֽ����ļ�����ķ�ʽ��
		 */
		
		getClass_3();
	}

	public static void getClass_3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String className = "cn.itcast.domain.Person";
		
		/*
		 * 1��ͨ�������������ƣ����ض�Ӧ���ֽ����ļ�������װ���ֽ����ļ�����Class.
		 */
		Class clazz = Class.forName(className);
//		System.out.println(clazz);
		
		//ͨ��newInstance()�Ϳ��Դ����ֽ����������ʾ�����ʵ����
		/*
		 * 2��ͨ��new�������������ʵ����
		 * 3�����ø���Ĺ��캯����
		 * ͨ����������඼�����ṩ�ղ����Ĺ��캯����
		 * û�ж�Ӧ�Ĺ��캯�����ᱨInstantiationException
		 * ������ṩ������Ȩ�޲������ᱨIllegalAccessException
		 * 
		 */
		Object obj = clazz.newInstance();
		
		
		/* Person p = new Person();
		 * 1������Person�࣬����Person���װ���ֽ����ļ�����
		 * 2��ͨ��new����Person����
		 * 3�����ù��캯���Զ����ʼ����
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

//		System.out.println(clazz1.getName());//��ȡ������֡�
	}
}
