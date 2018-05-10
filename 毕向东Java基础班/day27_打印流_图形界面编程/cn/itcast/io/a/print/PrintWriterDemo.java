package cn.itcast.io.a.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//读取键盘录入。将录入的数据转成大写保存到文件中。
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out,true);//true自动刷新，对println有效。
		
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			out.println(line.toUpperCase());
//			out.flush();
		}
		
		out.close();
	
		
		//想要将数据打印到文件中，并使用自动刷新。
		//PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true);
	}

}
