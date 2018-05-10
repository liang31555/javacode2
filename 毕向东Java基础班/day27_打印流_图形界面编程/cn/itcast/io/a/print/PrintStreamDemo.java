package cn.itcast.io.a.print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//需求：希望写一个整数，到目的地整数的表现形式不变。可以将整数转成字符串在写入到目的地。
		
//		FileOutputStream fos = new FileOutputStream("tempfile\\int.txt");
//		fos.write(String.valueOf(97));//字节流的write方法只将一个整数的最低字节写入到目的地;//00000000 00000000 00000001 01100001
//		fos.close();
		
		
//		FileOutputStream fos = new FileOutputStream("tempfile\\int.txt");
//		//需要额外功能吗？保证数据值的表示形式。需要。
//		PrintStream ps = new PrintStream(fos);
////		ps.write(97);// 只能写入最低字节。
//		ps.print(97);//将数据转成字符串在写入。保证数据值的表现形式。
//		ps.close();
		
		
		PrintStream ps = new PrintStream("tempfile\\int.txt");
		ps.print(98);
		ps.close();
	}

}
