package cn.itcast.reflect.demo;

import java.lang.reflect.Field;

public class Reflect_GetField {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * ��ȡ�ֶΡ�
		 */
		getFieldDemo();
	}

	public static void getFieldDemo() throws Exception {
		
		String className = "cn.itcast.domain.Person";
		Class clazz = Class.forName(className);
		
		String fieldName = "age";
		
		//��ȡage�ֶζ���
//		Field field = clazz.getField(fieldName);//��ȡ�ǹ������ֶΡ�
		Field field = clazz.getDeclaredField(fieldName);
		
//		getXXX:��ȡ�������й����ĳ�Ա��
//		getDeclaredXXX:��ȡ���������еĳ�Ա��
//		System.out.println(field);
		
		//�������ֵ�����ã��������ж���
		Object obj = clazz.newInstance();
		
		
		//ͨ�����Ҹ���AccessiableObject�ķ�����setAccessiable(true);
		field.setAccessible(true);//ȡ��Ȩ�޼�飬�������ʡ�һ�㲻����˽�С�
		field.set(obj, 30);//IllegalAccessException:age�ֶ���˽�еġ�
		
		System.out.println(field.get(obj));
	}

}
