package cn.itcast.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPRece {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("udp ���ն� run");
		/*
		 * ����һ��udp�Ľ��նˡ����շ��͹��������ݡ�����ʾ����Ļ�ϡ�
		 * ˼·��
		 * 1������udp  socket���񡣶��Ҽ�ס�����ն�һ��Ҫ��ȷ�˿ڡ������ղ������ݡ�
		 * 2���������ݡ�֮ǰ�Ƚ����ݴ洢�����ݰ��С�
		 * 3���ȶ������ݰ���
		 * 4��ͨ�����ݰ������ȡ���ݰ������ݣ����Ͷ˵�ip�����Ͷ˵Ķ˿ڣ����͹��������ݡ�
		 * 5���ر���Դ��
		 * 
		 */
//		1������udpsocket����
		DatagramSocket ds = new DatagramSocket(10000);
		
//		2���������ݡ�֮ǰ�Ƚ����ݴ洢�����ݰ��С�
//		3���ȶ������ݰ���
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		ds.receive(dp);//����
//		4��ͨ�����ݰ������ȡ���ݰ������ݣ����Ͷ˵�ip�����Ͷ˵Ķ˿ڣ����͹��������ݡ�
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String text = new String(dp.getData(),0,dp.getLength());
		
		System.out.println(ip+":"+port+":"+text);
//		5���ر���Դ��
		ds.close();
	}

}
