package cn.itcast.regex.test;

import java.util.Arrays;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		test_3();
		
	}
	
	/*
	 * 练习一：
	 * 我我.....我我.我....我.要.要要.....要.要学....学...学学....学.学编..编....编..编.编.程程.程.....程.程程
	 * 还原成：我要学编程。
	 * 思路：
	 * 可以使用正则表达式的替换功能。
	 * 发现其中有叠词，还有一些 . 
	 * 
	 * 
	 */
	public static void test_1(){
		String str = "我我.....我我.我....我.要.要要.....要.要学....学...学学....学.学编..编....编..编.编.程程.程.....程.程程";
		//1,先将 . 去掉。
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		
		//2,用叠词中的一个替换叠词。
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	/*
	 * 练习二：
	 * 127.0.0.1  3.3.3.3     192.168.104.23  10.10.10.10
	 * 要求按照ip地址的分类进行从小到大的排序。
	 * 
	 * 
	 */
	public static void test_2(){
		String str_ips = "127.0.0.1  3.3.3.3     192.168.104.23  10.10.10.10";
		
		/*
		 * 应该先让这些ip地址的每一段的位数都是3位，这样才可以通过字符串自然排序。
		 * 不足3位用0补，每一段要补的0的个数也不一致。咋补呢？
		 * 
		 * 干脆，按照每一段最大的的补零数去补，保证每一个段至少有三位，
		 * 然后每一段只取最后三位。
		 * 
		 * 替换。
		 */
		//1,先每一段都补两个0.
		str_ips = str_ips.replaceAll("(\\d+)", "00$1");
		System.out.println(str_ips);
		//00127.000.000.001  003.003.003.003     00192.00168.00104.0023  0010.0010.0010.0010
		
		//2,只保留三位。
		str_ips = str_ips.replaceAll("0*(\\d{3})", "$1");
		System.out.println(str_ips);
		//127.000.000.001  003.003.003.003     192.168.104.023  010.010.010.010
		
		
		String[] ips = str_ips.split(" +");
		
		Arrays.sort(ips);//按照字符串的自然顺序。排序的结果不是对的，因为ip的每一段位数是不一致的。
		
		for(String ip : ips){
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
		
	}
	
	/*
	 * 练习三:校验电子邮件地址 E-mail。
	 * 
	 */
	public static void test_3(){
		
		String mail = "abc12@sina.com.cn";
		
		String regex = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
		
		regex = "\\w+@\\w+(\\.\\w+)+";//1@1.1  宽泛的匹配。
		
		System.out.println(mail+":"+mail.matches(regex));
		
	}
	
	
	
	
	
	
	
	
	
	
}
