package cn.itcast.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("�ͻ�������.......");
		
		/*
		 * ����ͨ��tcp���佫���ݷ��͸���������
		 * ˼·��
		 * 1������tcp�Ŀͻ���socket����ȷ����˵ĵ�ַ�Ͷ˿ڡ�
		 * 2�����ͨ�������ɹ��ͻ����socket io����
		 * 		�ͻ�����Ҫ���ľͻ�ȡsocket����������������ݷ���Ŀ�ĵط���ˡ�
		 * 3��ͨ��socket����������ݷ��͡�
		 * 4���ر���Դ��
		 */
		
//		1������tcp�Ŀͻ���socket����ȷ����˵ĵ�ַ�Ͷ˿ڡ�
		Socket s = new Socket("192.168.1.223",10003);
		
//		2�����ͨ�������ɹ��ͻ����socket io����
//			�ͻ�����Ҫ���ľͻ�ȡsocket����������������ݷ���Ŀ�ĵط���ˡ�
		OutputStream out = s.getOutputStream();
		
//		3��ͨ��socket����������ݷ��͡�
		out.write("hello tcp ���ˣ�".getBytes());
		
//		4���ر���Դ��
		s.close();

	}

}
