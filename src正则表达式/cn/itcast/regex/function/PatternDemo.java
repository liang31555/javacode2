package cn.itcast.regex.function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//演示正则表达式的获取功能。
		
		//需求：获取字符串中由三个字母组成的单词。
		//da jia zhu yi le,ming tian bu fang jia,over!
		
		
		String str = "da jia zhu yi le,ming tian bu fang jia,over!";
		System.out.println(str);
		//定义规则。
		String regex = "\\b[a-z]{3}\\b";
		
		//1,将正则字符串编译成正则对象。
		Pattern p = Pattern.compile(regex);
		
		//2,将正则对象和字符串相关联，并获取匹配器。
		Matcher m = p.matcher(str);
		
		//3,使用find的方法
//		System.out.println(m.find());
//		System.out.println(str.substring(m.start(),m.end()));
//		System.out.println(m.group());
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
}
