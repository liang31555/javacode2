package cn.itcast.io.b.mergefile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MergeFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//合并碎片文件。
		/*
		 * 思路:
		 * 1，碎片文件有很多，每一个碎片都需要和读取流关联。
		 * 2，每一个读取流读取到的数据都需要通过一个输出流写入到一个文件中。
		 * 3，原理：多个源--->一个目的地。
		 * 
		 * 
		 * 如下代码的问题：
		 * 碎片过多，会产生很多的输入流对象，这是正常的，不正常在于，面对每一个输入流对象去操作。
		 * 当流对象过多时，必须先存储起来。面的流对象的容器操作更容易。
		 * 1，需要容器。
		 * 2，将流对象和碎片文件关联后存储到容器中。
		 * 3，遍历容器获取其中的流对象，在进行频繁的读写操作。
		 * 4，即使关流也是遍历容器对每一个流对象进行close的调用。
		 * 参阅MergeFileTest2.java
		 */
		
		FileInputStream fis1 = new FileInputStream("E:\\PartFiles\\1.part");
		FileInputStream fis2 = new FileInputStream("E:\\PartFiles\\2.part");
		FileInputStream fis3 = new FileInputStream("E:\\PartFiles\\3.part");
		FileInputStream fis4 = new FileInputStream("E:\\PartFiles\\4.part");
		FileInputStream fis5 = new FileInputStream("E:\\PartFiles\\5.part");
		FileInputStream fis6 = new FileInputStream("E:\\PartFiles\\6.part");
		
		
		FileOutputStream fos = new FileOutputStream("E:\\PartFiles\\0.mp3");
		
		byte[] buf = new byte[1024*1024];
		
		int len1 = fis1.read(buf);
		fos.write(buf,0,len1);
		int len2 = fis2.read(buf);
		fos.write(buf,0,len2);
		int len3 = fis3.read(buf);
		fos.write(buf,0,len3);
		int len4 = fis4.read(buf);
		fos.write(buf,0,len4);
		int len5 = fis5.read(buf);
		fos.write(buf,0,len5);
		int len6 = fis6.read(buf);
		fos.write(buf,0,len6);
		
		
		fos.close();
		fis1.close();
		fis2.close();
		fis3.close();
		fis4.close();
		fis5.close();
		fis6.close();
	}

}
