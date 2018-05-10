package cn.itcast.regex;

import java.util.Arrays;

public class YourRegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
//		test_1();
//		test_2();
		checkMail();
	}
	
	/*
	 * "我我....我我我....我要....要...要要....要要..学学学...学学编...编编..编编程程....程..程程"
	 * 还原成：我要学编程。
	 * 
	 */
	public static void test_1(){
		String temp = "我我....我我我....我要....要...要要....要要..学学学...学学编...编编..编编程程....程..程程";
		
		//1,明确要使用替换。replaceAll(regex,String);
		
		//2,将点干掉。
		temp = temp.replaceAll("\\.+", "");
		//3,将叠词干掉。
		temp = temp.replaceAll("(.)\\1+", "$1");
		System.out.println(temp);
		
		
	}
	
	
	
	

	
	/* 练习2：对ip地址进行排序。
	 * 192.168.1.200  10.10.10.10   3.3.50.3  127.0.0.1
	 */
	public static void test_2(){
		
		String temp = "192.168.1.200  17.10.10.10    3.3.50.3  127.0.0.1";
		
		
		
		/*
		排序出现问题了。是按照字符串字典顺序排的序。
		问题在哪呢？是因为每一个地址段的位数不对。
		如果位数都是三位就可以了。只有补0了。
		每一段位数都不同，咋补？
		干脆，按照最大所需0的个数补齐。每一段都补两个0.
		*/
		
		
//		String[] ips = temp.split(" +");
//		Arrays.sort(ips);
//		for(String ip : ips){
//			System.out.println(ip);
//		}
		
		
		//补两个0.
		temp = temp.replaceAll("(\\d+)", "00$1");
		System.out.println(temp);//00192.00168.001.00200  0017.0010.0010.0010    003.003.0050.003  00127.000.000.001
		
		//保留最后每段3位。
		temp = temp.replaceAll("0*(\\d{3})", "$1");
		System.out.println(temp);
		
		String[] ips = temp.split(" +");
		Arrays.sort(ips);
		for(String ip : ips){
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
	}
	
	
	/*
	 * 校验邮件地址。
	 */
	public static void checkMail(){
		
		String  mail = "abc12@sina.com";
		
		String regex = "\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";
		regex = "\\w+@\\w+(\\.\\w+)+";//1@1.1
		
		boolean b = mail.matches(regex);
		
		System.out.println(mail+":"+b);
		
		
	}
	
	
	
}
