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

		System.out.println("udp2 ���ն� run");
		
		// 1������udpsocket����
		DatagramSocket ds = new DatagramSocket(10001);
		while (true) {


			// 2���������ݡ�֮ǰ�Ƚ����ݴ洢�����ݰ��С�
			// 3���ȶ������ݰ���
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);// ����
			// 4��ͨ�����ݰ������ȡ���ݰ������ݣ����Ͷ˵�ip�����Ͷ˵Ķ˿ڣ����͹��������ݡ�
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(), 0, dp.getLength());

			System.out.println(ip + ":" + port + ":" + text);

		}
		// 5���ر���Դ��
//		ds.close();
	}

}
