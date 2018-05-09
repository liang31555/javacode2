package cn.itcast.regex.demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 需求：对QQ号码进行校验。
		// 要求：必须5~15位，0不可以开头 ，必须全是数字。

		String qq = "1";
		char ch = qq.charAt(0);
	
		
		boolean b = qq.matches("[1-9]\\d+");  
		System.out.println(qq+"::::"+b);
		
		//这样功能，可以完成qq号的校验，但是有点麻烦。
//		boolean b = checkQQ(qq);
//		System.out.println(qq + ":" + b);
	}

	// 对QQ号码进行校验。
	public static boolean checkQQ(String qq) {

		// 1,获取qq的长度，判断是5~15位。
		int len = qq.length();
		if (len >= 5 && len <= 15) {

			// 2,是否是0开头。
			if (!qq.startsWith("0")) {

				try {
					Long.parseLong(qq);

					return true;
				} catch (NumberFormatException e) {
//					System.out.println("非法数值");
				}

			}

		}

		return false;
	}

}
