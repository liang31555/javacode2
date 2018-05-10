package cn.itcast.io.a.charstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * 需求1：通过流写一个篇文章，里面有中文。"你好你好"。indexOf('好');
		 */
//		writeCNText();
		
		
		/*
		 * 需求2：一篇文章中出现了多少个好字。读取数据。判断好字并计数。
		 * 思路：读取一个文本，获取内容判断好字。
		 */
		
		 readCNText();
		
		/*
		 * 解决需求2问题：
		 * 使用FileReader。
		 * 
		 */
		 System.out.println("-----------读取字符-------------");
		readCNTextByReader();
		
	}

	public static void readCNTextByReader() throws IOException {

		//创建一个读取字符文件的读取流对象。FileReader。
		FileReader fr = new FileReader("tempfile\\cn.txt");//这个流的底层使用的是FileInputStream
		
//		int ch = fr.read();
//		System.out.println("读取一个字符："+ch);
//		int ch1 = fr.read();//一次读取一个中文，读取多个字节查表转成中文。
//		System.out.println("读取一个字符："+(char)ch1);
		int ch = 0;
		int count = 0;
		while((ch=fr.read())!=-1){
			if(ch=='好'){
				count++;
			}
		}
		System.out.println("count="+count);
		fr.close();
	}

	public static void readCNText() throws IOException {
		FileInputStream fis = new FileInputStream("tempfile\\cn.txt");
		
		//一次读一个字节。这样对中文是无法判断。怎么解决呢？一个中文默认是两个字节。
		//读取所有的字节，存储起来(字节数组)，变成字符串。然后找指定的字符。
		
//		byte[] buf = new byte[4];
//		int len = 0;
//		while((len=fis.read(buf))!=-1){
//			String str = new String(buf,0,len);
//			System.out.println(str);
//		}
		
//		int ch = 0;
//		while((ch=fis.read())!=-1){
//			System.out.println(ch);
//		}
		
		int ch = fis.read();
		System.out.println("读取一个字节："+ch);
		int ch1 = fis.read();
		System.out.println("读取一个字节："+ch1);
		fis.close();
		
	}

	public static void writeCNText() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("tempfile\\cn.txt");
		
		fos.write("你好你好".getBytes());
		
		fos.close();
	}

}
