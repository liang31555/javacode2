package cn.itcast.net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String str_url = "http://192.168.1.223:8080/myweb/2.html";
		
		//将url地址封装成对象。
		URL url = new URL(str_url);
		
//		System.out.println("getProtocol:"+url.getProtocol());
//		System.out.println("getHost:"+url.getHost());
//		System.out.println("getPort:"+url.getPort());
//		System.out.println("getPath:"+url.getPath());
//		System.out.println("getFile:"+url.getFile());
//		System.out.println("getQuery:"+url.getQuery());
		
		//获取指定资源的连接对象。//封装了socket。
		URLConnection conn = url.openConnection();
		
//		System.out.println(conn);
		
		InputStream in = conn.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
	}

}
