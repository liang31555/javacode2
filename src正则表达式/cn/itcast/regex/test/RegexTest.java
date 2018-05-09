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
	 * ��ϰһ��
	 * ����.....����.��....��.Ҫ.ҪҪ.....Ҫ.Ҫѧ....ѧ...ѧѧ....ѧ.ѧ��..��....��..��.��.�̳�.��.....��.�̳�
	 * ��ԭ�ɣ���Ҫѧ��̡�
	 * ˼·��
	 * ����ʹ��������ʽ���滻���ܡ�
	 * ���������е��ʣ�����һЩ . 
	 * 
	 * 
	 */
	public static void test_1(){
		String str = "����.....����.��....��.Ҫ.ҪҪ.....Ҫ.Ҫѧ....ѧ...ѧѧ....ѧ.ѧ��..��....��..��.��.�̳�.��.....��.�̳�";
		//1,�Ƚ� . ȥ����
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		
		//2,�õ����е�һ���滻���ʡ�
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	/*
	 * ��ϰ����
	 * 127.0.0.1  3.3.3.3     192.168.104.23  10.10.10.10
	 * Ҫ����ip��ַ�ķ�����д�С���������
	 * 
	 * 
	 */
	public static void test_2(){
		String str_ips = "127.0.0.1  3.3.3.3     192.168.104.23  10.10.10.10";
		
		/*
		 * Ӧ��������Щip��ַ��ÿһ�ε�λ������3λ�������ſ���ͨ���ַ�����Ȼ����
		 * ����3λ��0����ÿһ��Ҫ����0�ĸ���Ҳ��һ�¡�զ���أ�
		 * 
		 * �ɴ࣬����ÿһ�����ĵĲ�����ȥ������֤ÿһ������������λ��
		 * Ȼ��ÿһ��ֻȡ�����λ��
		 * 
		 * �滻��
		 */
		//1,��ÿһ�ζ�������0.
		str_ips = str_ips.replaceAll("(\\d+)", "00$1");
		System.out.println(str_ips);
		//00127.000.000.001  003.003.003.003     00192.00168.00104.0023  0010.0010.0010.0010
		
		//2,ֻ������λ��
		str_ips = str_ips.replaceAll("0*(\\d{3})", "$1");
		System.out.println(str_ips);
		//127.000.000.001  003.003.003.003     192.168.104.023  010.010.010.010
		
		
		String[] ips = str_ips.split(" +");
		
		Arrays.sort(ips);//�����ַ�������Ȼ˳������Ľ�����ǶԵģ���Ϊip��ÿһ��λ���ǲ�һ�µġ�
		
		for(String ip : ips){
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
		
	}
	
	/*
	 * ��ϰ��:У������ʼ���ַ E-mail��
	 * 
	 */
	public static void test_3(){
		
		String mail = "abc12@sina.com.cn";
		
		String regex = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
		
		regex = "\\w+@\\w+(\\.\\w+)+";//1@1.1  ����ƥ�䡣
		
		System.out.println(mail+":"+mail.matches(regex));
		
	}
	
	
	
	
	
	
	
	
	
	
}
