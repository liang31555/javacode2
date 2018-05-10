package cn.itcast.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		5，获取一篇文章中 "传智播客" 出现的次数。
		/*
		 * 思路：
		 * 1，读取这篇文章中的每一行。
		 * 2，对每一个计算 关键字符串的次数。
		 * 3，对每一行的进行累加。
		 */
		
		File file = new File("Test25.java");
		String key = "设备";
		int count = getKeyCount(file,key);
		System.out.println(key+"::"+count);
	}

	public static int getKeyCount(File file, String key) throws IOException {
		
		int count = 0;
		
		BufferedReader bufr = null;
		try{
			bufr = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=bufr.readLine())!=null){
				count += getKeyCountInLine(line,key);
			}
		}finally{
			if(bufr!=null){
				try{
					bufr.close();
				}catch(IOException e){
					throw new RuntimeException();
				}
			}
		}
		
		return count;
	}

	private static int getKeyCountInLine(String line, String key) {
	
		int count = 0;
		int index = 0;
		
		while((index=line.indexOf(key, index))!=-1){
			index = index + key.length();
			count++;
		}
		
		return count;
	}

}
