package cn.itcast.io.a.splitfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderPartConfigDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//解析partConfig文件中的信息。
		
		File configFile = new File("E:\\PartFiles\\7.partconfig");
		readPathConfig(configFile);

	}

	public static void readPathConfig(File configFile) throws IOException {
		
		/*
		 * 配置文件规律，只要读取一行文本，按照 = 对文本进行切割即可。
		 */
		BufferedReader bufr = new BufferedReader(new FileReader(configFile));
		
		String line = null;
		while((line=bufr.readLine())!=null){
			String[] arr = line.split("=");
			System.out.println(arr[0]+":::::"+arr[1]);
			//map.put(arr[0],arr[1]);
		}
		/*
		 *  发现配置文件信息很多，需要进行存储。
		 *  用哪个容器呢？个数不确定，就使用集合。
		 *  发现信息中存在对应关系，使用Map集合。
		 *  发现一点配置文件中的信息都是字符串，这些信息不在内存中而是在硬盘上。
		 *  map中和io技术集合的集合对象： Properties，它里面存储的键值都是字符串，通常这个集合就用于配置文件的操作。
		 *  
		 */
		
		
		bufr.close();
		
		
	}

}
