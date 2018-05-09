package cn.itcast.regex.demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ���󣺶�QQ�������У�顣
		// Ҫ�󣺱���5~15λ��0�����Կ�ͷ ������ȫ�����֡�

		String qq = "1";
		char ch = qq.charAt(0);
	
		
		boolean b = qq.matches("[1-9]\\d+");  
		System.out.println(qq+"::::"+b);
		
		//�������ܣ��������qq�ŵ�У�飬�����е��鷳��
//		boolean b = checkQQ(qq);
//		System.out.println(qq + ":" + b);
	}

	// ��QQ�������У�顣
	public static boolean checkQQ(String qq) {

		// 1,��ȡqq�ĳ��ȣ��ж���5~15λ��
		int len = qq.length();
		if (len >= 5 && len <= 15) {

			// 2,�Ƿ���0��ͷ��
			if (!qq.startsWith("0")) {

				try {
					Long.parseLong(qq);

					return true;
				} catch (NumberFormatException e) {
//					System.out.println("�Ƿ���ֵ");
				}

			}

		}

		return false;
	}

}
