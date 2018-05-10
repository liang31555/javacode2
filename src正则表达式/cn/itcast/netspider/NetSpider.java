package cn.itcast.netspider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
		
		/*
		 * 网络爬虫：其实就是一个应用程序，获取网络中的指定信息(符合指定规则的信息)。
		 * 
		 * 网络中的邮件地址。
		 * 
		 */
		File file = new File("tempfile\\mail.html");
		String regex = "\\w+@\\w+(\\.\\w+)+";
		
//		List<String> list = getMails(file,regex);
		String str_url = "http://bbs.tianya.cn/post-enterprise-401802-2.shtml";
		
		//http://tieba.baidu.com/p/2088202080 备选。
		
		List<String> list = getMailsByNet(str_url, regex);
		for(String mail : list){
			System.out.println("List:"+mail);
		}
	}
	//基于网络。
	public static List<String> getMailsByNet(String str_url,String regex) throws IOException{
		
		List<String> list = new ArrayList<String>();
		
		//1,将str_url封装成URL对象。
		URL url = new URL(str_url);
		
		//2,打开连接。
		URLConnection conn = url.openConnection();
		
		//3,获取读取流。
		InputStream in = conn.getInputStream();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));
		
		//4,将正则表达式编译成对象。
		Pattern p = Pattern.compile(regex);
		
		String line = null;
		while((line=bufIn.readLine())!=null){
			
			Matcher m = p.matcher(line);
			
			while(m.find()){
				list.add(m.group());
				
			}
			
		}
		
		bufIn.close();
		
		return list;
	}
	
	//基于本地文件。
	public static List<String> getMails(File file, String regex) throws IOException {
	
		
		List<String> list = new ArrayList<String>();
		//1,读取文件
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		
		//2,将正则规则编译成对象。
		Pattern p = Pattern.compile(regex);
		
		String line = null;
		while((line=bufr.readLine())!=null){
			
			Matcher m = p.matcher(line);
			
			while(m.find()){
				list.add(m.group());
			}
			
		}
		
		
		
		bufr.close();
		
		return list;
	}

}
