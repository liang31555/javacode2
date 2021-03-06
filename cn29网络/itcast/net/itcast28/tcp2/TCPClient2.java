package cn.itcast.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		 * 案例二：实现客户端和服务端的收发过程。
		 * 客户端
		 */
		System.out.println("客户端2 启动.......");
//		创建客户端socket对象。明确服务端地址和端口。
		Socket s = new Socket("192.168.1.223", 10004);
		
//		发送数据，通过socket输出流完成。
		OutputStream out = s.getOutputStream();
		out.write("服务端，我来了".getBytes());
		
//		读取服务端返回的数据，通过socket输入流
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
//		关闭资源。
		s.close();
		
		
	}

}
