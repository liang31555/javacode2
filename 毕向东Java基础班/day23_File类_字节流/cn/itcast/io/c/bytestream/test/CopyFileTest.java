package cn.itcast.io.c.bytestream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * 练习：复制文件。
		 * 原理；读取一个已有的数据，并将这些读到的数据写入到另一个文件中。
		 */
		//1,明确源和目的。
		File srcFile = new File("E:\\1.mp3");
		File destFile = new File("E:\\copy_2.mp3");
		
		//2,明确字节流 输入流和源相关联，输出流和目的关联。
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		//3, 使用输入流的读取方法读取字节，并将字节写入到目的中。
		int ch = 0;
		while((ch=fis.read())!=-1){
			fos.write(ch);
		}
		
		
		//4,关闭资源。
		fos.close();
		fis.close();
		
	}

}
