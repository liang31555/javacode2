package cn.itcast.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		matchesDemo();
		
//		splitDemo();
		
//		replaceDemo();
		
		getDemo();
	}

	public static void getDemo() {
		
		/*
		 * 实现获取：将符合规则的内容取出来，
		 * 用到正则表达式对象。java.util.regex.Pattern
		 * 
		 * 1,将字符串规则封装成Pattern对象。compile(regex);
		 * 2,通过正则对象获取匹配器对象。用对将正则规则作用到要操作的字符串上。
		 * 3，通过匹配器对象的方法，对字符串进行操作。
		 *  Pattern p = Pattern.compile("a*b");//将规则编译成对象。
		 *  Matcher m = p.matcher("aaaaab"); //和要操作的字符串关联，生成匹配器对象。
		 *  boolean b = m.matches();//使用匹配对象方法对字符串操作。
		 */
		//获取字符串中符合规则的内容。
		String temp = "da jia zhu yi le,ming tian fang jia le!";
		System.out.println(temp);
		//取出由三个字母组成的单词。
		String regex = "\\b[a-zA-Z]{3}\\b";
		
		//1,将规则编译成Pattern对象。
		Pattern p = Pattern.compile(regex);
		
		//2,和字符串关联，获取匹配器对象。
		Matcher m = p.matcher(temp);
		
//		System.out.println(m.find());
//		System.out.println(m.group());
		while(m.find()){
			System.out.println(m.start()+":"+m.group()+":"+m.end());
		}
		
	}

	public static void replaceDemo() {
		
//		String temp = "15900001111";		
//		temp = temp.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");//$可以在多参数时，
//											后面的参数可以通过$编号的形式取到前一个参数的组。
		
		String temp = "qwe##rty$$$$$iouzzzzzzztyu";
		temp  = temp.replaceAll("(.)\\1+", "$1");
		System.out.println(temp);
		
	}

	public static void splitDemo() {
		
//		String temp = "zhangsan    lisi       wangwu";
//		String regex = " +";
//		String temp = "zhangsan.lisi.wangwu";
//		String regex = "\\.";
		
		String temp = "qwe##rty$$$$$iouzzzzzzztyu";
		String regex = "(.)\\1+";//为了实现规则的复用，用()将需要复用的规则封装，
//								就称为了正则表达式中的组，每一个组都有编号，从1开始。
//								通过使用编号就可以复用对应组的规则内容。注意：编号必须用到组的后面。
//								也就是说：先封装完在调用。
		
		
		String[] names = temp.split(regex);
		for(String name : names){
			System.out.println("-"+name+"-");
		}
		
		
	}

	public static void matchesDemo() {

		// 需求：校验手机号码是否正确。

		String tel = "15800001111";
		String regex = "1[358]\\d{9}";
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
	}

}
