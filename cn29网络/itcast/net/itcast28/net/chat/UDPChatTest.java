package cn.itcast.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPChatTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 案例一：通过udp实现群聊程序。 思路： 这个程序中既有收又有发，需要同时执行，需要使用多线程技术。
		 * 一个线程负责发，一个线程负责收。需要两个任务。
		 */

		//发送端的socket 接收端的socket
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		
		//创建任务对象。
		Send send = new Send(sendSocket);
		Rece rece = new Rece(receSocket);
		
		//创建线程并开启。非无情
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(rece);
		t1.start();
		t2.start();
	}

}

// 发送任务
class Send implements Runnable {

	private DatagramSocket ds;

	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(
					System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				byte[] buf = line.getBytes();// 将数据转成字节数组。
				DatagramPacket dp = new DatagramPacket(buf, buf.length,
						InetAddress.getByName("192.168.1.223"), 10002);
				ds.send(dp);
				if ("886".equals(line)) {
					break;
				}
			}

			// 4，关闭资源。
			ds.close();
		} catch (IOException e) {

		}
	}
}

// 接收任务。
class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		while (true) {

			try {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);// 阻塞
				
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println(ip + ":" + port + ":" + text);
				if(text.equals("886")){
					System.out.println(ip+"....离开聊天室");
				}
			} catch (IOException e) {

			}
		}

	}

}
