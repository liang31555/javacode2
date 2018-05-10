package cn.itcast.net.udp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("udp2 发送端 run");
		
//		1，需要先建立udp的socket。它具备者发送或者接收功能。
		DatagramSocket ds = new DatagramSocket(9999);
		
//		2，将数据封装到数据包中。数据包对象是DatagramPacket。数据来自于键盘录入。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			byte[] buf = line.getBytes();//将数据转成字节数组。
//			将字节数组封装到数据包中。
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.223"), 10001);
//			3，使用socket对象的send方法将数据包发送出去。
			ds.send(dp);
		}
		
//		4，关闭资源。
		ds.close();
	}

}
