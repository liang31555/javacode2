package cn.itcast.regex;

public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * ��QQ�Ž���У�顣
		 * Ҫ��5-15λ�� 0�����Կ�ͷ�����붼�����֡�
		 */
		
		String qq = "1234567890123456";
//		boolean b = checkQQ(qq);
//		System.out.println(qq+":"+b);
		boolean b = qq.matches("[1-9][0-9]{4,14}");
		System.out.println(qq+":"+b);
	}

	public static boolean checkQQ(String qq) {
		boolean flag = false;
		int len = qq.length();
		if(len>=5 && len<=15){
			if(!qq.startsWith("0")){
				try{
				Long num = Long.parseLong(qq);
				flag = true;
				}catch(NumberFormatException e){
					System.out.println("���ַǷ�����");
				}
			
			}
			
		}
		
		
		return flag;
	}

}
