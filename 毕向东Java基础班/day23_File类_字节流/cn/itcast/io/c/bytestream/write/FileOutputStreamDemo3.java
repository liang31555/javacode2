package cn.itcast.io.c.bytestream.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {

		File file = new File("k:\\file.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write("abcde".getBytes());

		} catch (IOException e) {
			System.out.println(e.toString() + "----");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException("");
				}
			}

		}

	}

}
