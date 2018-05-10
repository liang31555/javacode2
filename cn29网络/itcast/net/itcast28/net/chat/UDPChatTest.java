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
		 * ����һ��ͨ��udpʵ��Ⱥ�ĳ��� ˼·�� ��������м��������з�����Ҫͬʱִ�У���Ҫʹ�ö��̼߳�����
		 * һ���̸߳��𷢣�һ���̸߳����ա���Ҫ��������
		 */

		//���Ͷ˵�socket ���ն˵�socket
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		
		//�����������
		Send send = new Send(sendSocket);
		Rece rece = new Rece(receSocket);
		
		//�����̲߳�������
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(rece);
		t1.start();
		t2.start();
	}

}

// ��������
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
				byte[] buf = line.getBytes();// ������ת���ֽ����顣
				DatagramPacket dp = new DatagramPacket(buf, buf.length,
						InetAddress.getByName("192.168.1.223"), 10002);
				ds.send(dp);
				if ("886".equals(line)) {
					break;
				}
			}

			// 4���ر���Դ��
			ds.close();
		} catch (IOException e) {

		}
	}
}

// ��������
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
				ds.receive(dp);// ����
				
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println(ip + ":" + port + ":" + text);
				if(text.equals("886")){
					System.out.println(ip+"....�뿪������");
				}
			} catch (IOException e) {

			}
		}

	}

}
