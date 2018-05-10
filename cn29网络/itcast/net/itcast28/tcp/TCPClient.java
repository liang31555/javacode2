package cn.itcast.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("客户端运行.......");
		
		/*
		 * 需求：通过tcp传输将数据发送给服务器。
		 * 思路：
		 * 1，建立tcp的客户端socket。明确服务端的地址和端口。
		 * 2，如果通道建立成功就会出现socket io流。
		 * 		客户端需要做的就获取socket流的中输出流将数据发送目的地服务端。
		 * 3，通过socket输出流将数据发送。
		 * 4，关闭资源。
		 */
		
//		1，建立tcp的客户端socket。明确服务端的地址和端口。
		Socket s = new Socket("192.168.1.223",10003);
		
//		2，如果通道建立成功就会出现socket io流。
//			客户端需要做的就获取socket流的中输出流将数据发送目的地服务端。
		OutputStream out = s.getOutputStream();
		
//		3，通过socket输出流将数据发送。
		out.write("hello tcp 来了！".getBytes());
		
//		4，关闭资源。
		s.close();

	}

}
