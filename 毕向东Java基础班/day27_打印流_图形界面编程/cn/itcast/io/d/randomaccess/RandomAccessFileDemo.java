package cn.itcast.io.d.randomaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * RandomAccessFile：
		 * 1，随机访问。
		 * 2，操作文件。
		 * 3，既可以读又可以写，
		 * 4，内部维护了用于存储数据的byte数组。
		 * 5，提供了一个对数组操作的文件指针。
		 * 6， 文件指针可以通过getFilePointer 方法读取，并通过 seek 方法设置。 
		 * 
		 * 注意：随机读写，数据需要规律，用RandomAccessFile类需要明确要操作的数据的位置。
		 */

//		writeFile();
		
		readFile();
		
	}

	public static void readFile() throws IOException {
	
		RandomAccessFile raf = new RandomAccessFile("tempfile\\random.txt", "r");
		//改变指针的位置，想读谁就读谁。
		raf.seek(8*3);
		
		
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		System.out.println("name="+name);
		
		int age = raf.readInt();
		System.out.println("age="+age);
		
		raf.close();
		
	}

	public static void writeFile() throws IOException {
		
		
	
		RandomAccessFile raf = new RandomAccessFile("tempfile\\random.txt", "rw");
		
		//写一些字符信息，姓名 +年龄。
//		raf.write("张三".getBytes());
//		raf.writeInt(97);//保证字节的原样性。
//		raf.write("李四".getBytes());
//		raf.writeInt(99);//保证字节的原样性。
		
		raf.seek(4);
		
		raf.write("王武".getBytes());
		raf.writeInt(102);
		
		System.out.println(raf.getFilePointer());
		
		raf.close();
		
	}

}
