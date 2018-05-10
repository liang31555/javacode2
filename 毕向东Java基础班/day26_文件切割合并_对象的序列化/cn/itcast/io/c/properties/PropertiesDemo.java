package cn.itcast.io.c.properties;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Properties集合的使用。

		// methodDemo_1();
//		methodDemo_2();
		methodDemo_3();

	}

	/*
	 * 保存到流中的方法(持久化)
	 */
	public static void methodDemo_3() throws IOException {

		Properties prop = new Properties();

		// 添加数据。
		prop.setProperty("zhangsan", "39");
		prop.setProperty("lisi", "29");
		
		//想要把数据保存到文件中，需要输出流。
		FileWriter fw = new FileWriter("info.properties");
		
		//使用store方法。
		prop.store(fw, "info");
		
		fw.close();
		

	}

	/*
	 * 演示从流中加载，。
	 */
	public static void methodDemo_2() throws IOException {

		File configFile = new File("E:\\PartFiles\\7.partconfig");
		FileReader fr = new FileReader(configFile);

		Properties prop = new Properties();
		// 使用Properties集合的load方法，就可以将流中的数据加载集合中。原理;ReaderPartConfigDemo.java
		// 中的readPathConfig();
		prop.load(fr);

		System.out.println(prop);

		fr.close();
	}

	// 1,基本使用，存和取。
	public static void methodDemo_1() {

		// 创建一个Properites集合。
		Properties prop = new Properties();

		// 添加数据。
		prop.setProperty("zhangsan", "39");
		prop.setProperty("lisi", "29");

		// 获取数据。一个。
		// String value = prop.getProperty("lisi");
		// System.out.println("value="+value);

		// 全部取出。map--set--iterator
		Set<String> set = prop.stringPropertyNames();
		// System.out.println("-- listing properties --");
		for (String name : set) {
			String value = prop.getProperty(name);
			System.out.println(name + ":" + value);
		}

		// prop.list(System.out);
	}

}
