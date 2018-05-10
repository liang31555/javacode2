package cn.itcast.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		 * ��������ʵ�ֿͻ��˺ͷ���˵��շ����̡�
		 * �ͻ���
		 */
		System.out.println("�ͻ���2 ����.......");
//		�����ͻ���socket������ȷ����˵�ַ�Ͷ˿ڡ�
		Socket s = new Socket("192.168.1.223", 10004);
		
//		�������ݣ�ͨ��socket�������ɡ�
		OutputStream out = s.getOutputStream();
		out.write("����ˣ�������".getBytes());
		
//		��ȡ����˷��ص����ݣ�ͨ��socket������
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
//		�ر���Դ��
		s.close();
		
		
	}

}
