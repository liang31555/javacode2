package cn.itcast.regex.function;

public class RegexFunctionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ʾƥ�䡣
//		matchesDemo();  
		
		//��ʾ�и
//		splitDemo();
		
		//��ʾ�滻��
//		replaceAllDemo();
		
		
		
	}

	private static void replaceAllDemo() {
		
//		String str = "qwer######tyuio########psdfg";
//		//��#�滻��@
//		str = str.replaceAll("#+", "@");
		
//		String str = "qwer######tyuio&&&&&&&psdfg";
//		//���������滻��@
//		str = str.replaceAll("(.)\\1+", "@");
		
//		String str = "qwer######tyuio&&&&&&&psdfg";
//		//���������滻�����е�һ��  ���###### ��#�滻��
//		//���ڵڶ���������ʹ�õ�һ����������е���ʱ������ʹ��$����������ĵ��á�\\1ֻ��ʹ����������ʽ�С�
//		str = str.replaceAll("(.)\\1+", "$1");
		
//		String str = "q����:20wer18600001111tyui99009877op[sdf666677778888999990000ghjkl;";
//		//����̳���ӵ���ϵ��ʽ���鶼�滻 ***
//		str = str.replaceAll("\\d{5,}", "***");
		
//		String str = "q����:20wer18600001111tyui99009877op[sdf666677778888999990000ghjkl;";
//		//����̳���ӵ���ϵ��ʽ���鶼�滻 ***
//		str = str.replaceAll("\\d{5,}", "***");
		
		String str = "18600001111";
		//���绰�е��м���λ�滻��****;
		str = str.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3");
		
		System.out.println(str);
		
		
	}

	private static void splitDemo() {
		
//		String str = "zhangsan,lisi,wangwu";
//		String str_regex = ",";
		
//		String str = "zhangsan.lisi.wangwu";
//		String str_regex = "\\.";
		
		
//		String str = "zhangsan        lisi     wangwu";
//		String str_regex = " +";
		
		//���յ��ʽ����и���ʾ��Ǻ��ߺ�ǰ��һ�¡�ǰ�߻������⣬��������ڸ���ǰ�ߵ����ݡ�
		//������������ʽ�н��и��ã�����Ҫ���õ����ݽ��з�װ��Ȼ����������װ���ɡ�
		//����ĸ����õ��� () ����װ��,��Ȼû�����֣�����������ʹ��()���з�װʱ���Զ��ĸ���Щ
		//С���Ž����˱�ţ���1��ʼ,��֮Ϊ������ʽ�е��顣ͨ����ı�žͿ��Ե���ָ�����飬���и��á�
		String str = "zhangsan#######lisi@@@@@@@@@@wangwu";
		String str_regex = "(.)\\1+";
		
		//(A)(B)(C)(D)\\1\\3\\2\\4   
		//  ((A)(B(C))) \\1((A)(B(C))) \\2(A) \\3 (B(C))\\4 (C)   ��Ƕ�ף����ɣ����������м��������ž��Ǽ��顣
		
		String[] arr = str.split(str_regex);
//		System.out.println(arr.length);
		for(String s : arr){
			System.out.println(s);
		}
		
	}

	private static void matchesDemo() {
		//�����ƥ��Ĺ��ܡ�
		//У���ֻ����롣
		String number = "18600001111";
		//����
		String number_regex = "1[358]\\d{9}";
		
		System.out.println(number + ":"+ number.matches(number_regex));
	}

}
