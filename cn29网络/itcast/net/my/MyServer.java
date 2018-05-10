package cn.itcast.net.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		/*
		 *  �Զ���server �����
		 *  ��ȡ���������Ϣ����������Ϣ��
		 */
		System.out.println("my server run....");
		ServerSocket ss = new ServerSocket(9090);
		
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"....connected");
		
		//��ȡ�ͻ��˵����ݡ�
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
		//���ͻ��˻������ݡ�
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='red' size='7'>��ӭ����</font>");
		
		
		s.close();
		ss.close();
		

	}

}
