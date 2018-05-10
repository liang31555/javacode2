package cn.itcast.regex;

public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 正则表达式:正确的规则。
		 * 专门用于对字符串的操作。
		 * 规则是由符号组成的。用操作字符串变得简单。
		 * 弊端：阅读性降低了。
		 * 所以学习正则其实就是学习符号的使用。
		 * 
		 * 1，匹配。
		 * 	String 类中提供了匹配boolean matches(regex)的方法。
		 * 
		 * 2，切割。
		 * String 类中提供了匹配String[] split(regex)的方法
		 * 
		 * 3，替换。
		 * String 类中提供了匹配String replaceAll(regex,string)的方法
		 * 
		 * 4，获取。
		 * 
		 * 
		 * 
		 */

		String QQ = "1234";
//		boolean b = checkQQ(QQ);
//		if(b){
//			System.out.println(QQ+" is  ok");
//		}else{
//		System.out.println(QQ+" is  nononon");
//		}
		
		boolean b = QQ.matches("[1-9]\\d{4,14}");  
		System.out.println(QQ+":"+b);
	
		
		
		String temp = "a12357389";
		
		boolean res = temp.matches("a\\d{5,7}");
		System.out.println(temp+":"+res);
	}

	/**
	 * 校验QQ号。5~15 只能是数字，0不能开头。
	 */
	public static boolean checkQQ(String QQ) {

		boolean b = false;
		// 1,获取长度，
		int len = QQ.length();

		// 2,判断长度。
		if (len >= 5 && len <= 15) {

			// 3,判断是否0开头。
			if (!QQ.startsWith("0")) {
				try {
					long qq_num = Long.parseLong(QQ);
					System.out.println("QQ:" + qq_num);

					b = true;
				} catch (NumberFormatException e) {
					System.out.println("非法QQ号");
				}

			} else {
				System.out.println("不能0开头");
			}

		} else {
			System.out.println("长度错误");
		}

		return b;
	}

}
