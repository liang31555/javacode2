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
	
		System.out.println("udp ���Ͷ� run");
		
		/*
		 * ͨ�������ĵ����˽⵽����UDP����Э��Ķ�����DatagramSocket��
		 * 
		 * ͨ��udp��Э�鷢��һ���ı����ݡ�
		 * ˼·��
		 * 1����Ҫ�Ƚ���udp��socket�����߱��߷��ͻ��߽��չ��ܡ�
		 * 2�������ݷ�װ�����ݰ��С����ݰ�������DatagramPacket��
		 * 3��ʹ��socket�����send���������ݰ����ͳ�ȥ��
		 * 4���ر���Դ��
		 */
		
//		1����Ҫ�Ƚ���udp��socket�����߱��߷��ͻ��߽��չ��ܡ�
		DatagramSocket ds = new DatagramSocket(8888);
		
//		2�������ݷ�װ�����ݰ��С����ݰ�������DatagramPacket��
		String text = "hello udp���ˡ�";
		byte[] buf = text.getBytes();//������ת���ֽ����顣
//		���ֽ������װ�����ݰ��С�
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10000);
		
//		3��ʹ��socket�����send���������ݰ����ͳ�ȥ��
		ds.send(dp);
		
//		4���ر���Դ��
		ds.close();
		

	}

}
