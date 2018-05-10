package cn.itcast.netspider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetSpider {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//1,将文件封装成File对象。
		File file = new File("mail.html");
		String regex = "\\w+@\\w+(\\.\\w+)+";
		List<String> mailList = getMails(file,regex);
		
		for(String mail : mailList){
			System.out.println(mail);
		}
		
	}

	public static List<String> getMails(File file,String regex) throws IOException {
		
		
		//1，读取数据。
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		
		//2，将正则封装成对象。
		Pattern p = Pattern.compile(regex);
		
		//3,定义list集合。
		List<String> list = new ArrayList<String>();
		
		String line = null;
		while((line=bufr.readLine())!=null){
			
			Matcher m = p.matcher(line);
			
			while(m.find()){
				list.add(m.group());
			}
		
		}
		
		
		return list;
	}

}
