package cn.itcast.regex.function;

public class RegexFunctionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//演示匹配。
//		matchesDemo();  
		
		//演示切割。
//		splitDemo();
		
		//演示替换。
//		replaceAllDemo();
		
		
		
	}

	private static void replaceAllDemo() {
		
//		String str = "qwer######tyuio########psdfg";
//		//将#替换成@
//		str = str.replaceAll("#+", "@");
		
//		String str = "qwer######tyuio&&&&&&&psdfg";
//		//将将叠词替换成@
//		str = str.replaceAll("(.)\\1+", "@");
		
//		String str = "qwer######tyuio&&&&&&&psdfg";
//		//将将叠词替换成其中的一个  多个###### 用#替换。
//		//当在第二个参数中使用第一个正则参数中的组时，可以使用$编号来完成组的调用。\\1只能使用在正则表达式中。
//		str = str.replaceAll("(.)\\1+", "$1");
		
//		String str = "q芳龄:20wer18600001111tyui99009877op[sdf666677778888999990000ghjkl;";
//		//将论坛帖子的联系方式数组都替换 ***
//		str = str.replaceAll("\\d{5,}", "***");
		
//		String str = "q芳龄:20wer18600001111tyui99009877op[sdf666677778888999990000ghjkl;";
//		//将论坛帖子的联系方式数组都替换 ***
//		str = str.replaceAll("\\d{5,}", "***");
		
		String str = "18600001111";
		//将电话中的中间四位替换成****;
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
		
		//按照叠词进行切割。叠词就是后者和前者一致。前者还是任意，必须后者在复用前者的内容。
		//必须在正则表达式中进行复用：将需要复用的内容进行封装，然后调用这个封装即可。
		//正则的复用用的是 () 来封装的,虽然没有名字，但是正则在使用()进行封装时，自动的给这些
		//小括号进行了编号，从1开始,称之为正则表达式中的组。通过组的编号就可以调用指定的组，进行复用。
		String str = "zhangsan#######lisi@@@@@@@@@@wangwu";
		String str_regex = "(.)\\1+";
		
		//(A)(B)(C)(D)\\1\\3\\2\\4   
		//  ((A)(B(C))) \\1((A)(B(C))) \\2(A) \\3 (B(C))\\4 (C)   组嵌套，技巧：从左起数有几个左括号就是几组。
		
		String[] arr = str.split(str_regex);
//		System.out.println(arr.length);
		for(String s : arr){
			System.out.println(s);
		}
		
	}

	private static void matchesDemo() {
		//正则的匹配的功能。
		//校验手机号码。
		String number = "18600001111";
		//规则。
		String number_regex = "1[358]\\d{9}";
		
		System.out.println(number + ":"+ number.matches(number_regex));
	}

}
