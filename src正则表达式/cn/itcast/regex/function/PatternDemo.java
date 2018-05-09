package cn.itcast.regex.function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ʾ������ʽ�Ļ�ȡ���ܡ�
		
		//���󣺻�ȡ�ַ�������������ĸ��ɵĵ��ʡ�
		//da jia zhu yi le,ming tian bu fang jia,over!
		
		
		String str = "da jia zhu yi le,ming tian bu fang jia,over!";
		System.out.println(str);
		//�������
		String regex = "\\b[a-z]{3}\\b";
		
		//1,�������ַ���������������
		Pattern p = Pattern.compile(regex);
		
		//2,�����������ַ��������������ȡƥ������
		Matcher m = p.matcher(str);
		
		//3,ʹ��find�ķ���
//		System.out.println(m.find());
//		System.out.println(str.substring(m.start(),m.end()));
//		System.out.println(m.group());
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
}
