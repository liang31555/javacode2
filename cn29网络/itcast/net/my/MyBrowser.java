package cn.itcast.net.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		 * 模拟一个浏览器。发送之前IE发送的http消息。
		 */
		Socket s = new Socket("192.168.1.223",8080);
		//把IE的信息发送给服务端。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("GET /myweb/3.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host: 192.168.1.223:8080");
		out.println("Connection: close");
		out.println();//空行。
		
		//读取服务端的数据。
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
		s.close();
		

	}

}
