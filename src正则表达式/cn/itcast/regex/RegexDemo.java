package cn.itcast.regex;

public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "booooook";
		
		boolean b = str.matches("bo{2,}k");  
		System.out.println(str+":"+b);

	}

}
