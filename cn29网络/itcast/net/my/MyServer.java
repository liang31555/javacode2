package cn.itcast.net.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		/*
		 *  自定义server 服务端
		 *  获取浏览器的信息。并反馈信息。
		 */
		System.out.println("my server run....");
		ServerSocket ss = new ServerSocket(9090);
		
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"....connected");
		
		//读取客户端的数据。
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
		//给客户端回馈数据。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='red' size='7'>欢迎光临</font>");
		
		
		s.close();
		ss.close();
		

	}

}
