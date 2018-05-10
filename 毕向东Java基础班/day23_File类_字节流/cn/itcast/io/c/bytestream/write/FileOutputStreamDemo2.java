package cn.itcast.io.c.bytestream.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamDemo2 {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		
		//需求：将数据续写到已有文件中。
		//FileOutputStream(File file, boolean append) 续写。
		//在下一行写入新的数据。

		File file = new File("tempfile\\file.txt");
		
		FileOutputStream fos = new FileOutputStream(file, true);
			
		String str = LINE_SEPARATOR+"itcast";
		fos.write(str.getBytes());
		
		fos.close();
		
	}

}
