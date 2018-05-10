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
		
		System.out.println("udp2 ���Ͷ� run");
		
//		1����Ҫ�Ƚ���udp��socket�����߱��߷��ͻ��߽��չ��ܡ�
		DatagramSocket ds = new DatagramSocket(9999);
		
//		2�������ݷ�װ�����ݰ��С����ݰ�������DatagramPacket�����������ڼ���¼�롣
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			byte[] buf = line.getBytes();//������ת���ֽ����顣
//			���ֽ������װ�����ݰ��С�
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.223"), 10001);
//			3��ʹ��socket�����send���������ݰ����ͳ�ȥ��
			ds.send(dp);
		}
		
//		4���ر���Դ��
		ds.close();
	}

}
