package cn.itcast.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		System.out.println("udp 发送端 run");
		
		/*
		 * 通过查阅文档，了解到用于UDP传输协议的对象是DatagramSocket。
		 * 
		 * 通过udp的协议发送一段文本数据。
		 * 思路：
		 * 1，需要先建立udp的socket。它具备者发送或者接收功能。
		 * 2，将数据封装到数据包中。数据包对象是DatagramPacket。
		 * 3，使用socket对象的send方法将数据包发送出去。
		 * 4，关闭资源。
		 */
		
//		1，需要先建立udp的socket。它具备者发送或者接收功能。
		DatagramSocket ds = new DatagramSocket(8888);
		
//		2，将数据封装到数据包中。数据包对象是DatagramPacket。
		String text = "hello udp来了。";
		byte[] buf = text.getBytes();//将数据转成字节数组。
//		将字节数组封装到数据包中。
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10000);
		
//		3，使用socket对象的send方法将数据包发送出去。
		ds.send(dp);
		
//		4，关闭资源。
		ds.close();
		

	}

}
