package cn.itcast.io.c.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppCountTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * 练习:定义功能记录程序运行次数，满足试用次数后，给出提示：试用次数已到，请注册。
		 * 
		 * 思路：
		 * 1，需要计数器。这个软件使用一次计数一次。每使用一次，就进行计数累计。
		 * 2，计数器是程序中的一个变量，程序启动计数器计数，可是程序结束这个计数器就消失了。
		 * 下次启动会重新进行计数，原来计数的值没有保留下来。咋办?
		 * 3，让这个计数器持久化。存储到文件中，为了标识数据可读性，数据起个名字。出现键值对。
		 * 而且还是一个持久化的键值对，Properties集合正好符合这个要求。
		 * 
		 */
		
		if(isStop()){
			System.out.println("试用次数已到，请注册");
			return;
		}
		runcode();
		

	}

	private static boolean isStop() throws IOException {
		
		//1,配置文件。
		File configFile = new File("tempfile\\app.properties");
		if(!configFile.exists()){//如果配置文件不存在，就创建。
			configFile.createNewFile();
		}
		
		//2,创建属性集。
		Properties prop = new Properties();
		
		//3,定义读取流和配置文件关联。
		FileInputStream fis = new FileInputStream(configFile);
		
		//4,将流关联的数据读取到属性集中。
		prop.load(fis);
		
		//5,通过属性集的指定键count，获取具体的次数。
		String value = prop.getProperty("count");
		int count = 0;
		//6, 对value进行判断，如果存在就对其自增。
		if(value!=null){
			count = Integer.parseInt(value);
			if(count>=5){
				return true;
			}
			
		}
		count++;//对其值进行自增。
		//7,将自增后的值和指定的键重新存储到属性集中，键相同，值覆盖。
		prop.setProperty("count", Integer.toString(count));
		
		//8,将属性集存储到配置文件中。对配置文件中的信息进行更新。
		FileOutputStream fos = new FileOutputStream(configFile);
		prop.store(fos, "app run count");
		
		//9,关闭资源。
		fos.close();
		fis.close();
		
		
		
		return false;
	}

	//程序主体。
	public static void runcode(){
		System.out.println("程序运行....play");
	}
}
