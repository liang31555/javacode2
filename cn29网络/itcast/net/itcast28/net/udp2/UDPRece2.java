package cn.itcast.net.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPRece2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("udp2 接收端 run");
		
		// 1，先有udpsocket服务。
		DatagramSocket ds = new DatagramSocket(10001);
		while (true) {


			// 2，接收数据。之前先将数据存储到数据包中。
			// 3，先定义数据包。
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);// 阻塞
			// 4，通过数据包对象获取数据包的内容，发送端的ip。发送端的端口，发送过来的数据。
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(), 0, dp.getLength());

			System.out.println(ip + ":" + port + ":" + text);

		}
		// 5，关闭资源。
//		ds.close();
	}

}
