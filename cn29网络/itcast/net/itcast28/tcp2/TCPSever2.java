package cn.itcast.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSever2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * ��������ʵ�ֿͻ��˺ͷ���˵��շ����̡� �������ˡ�
		 */
		System.out.println("�����2����.....");

		// ����tcp�����socket ��ȷ�˿ڡ�
		ServerSocket ss = new ServerSocket(10004);

		while (true) {
			// ��ȡ�ͻ��˶���
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress()
					+ ".....connected");

			// ��ȡ�ͻ��˵ķ��͹���������
			InputStream in = s.getInputStream();
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String text = new String(buf, 0, len);
			System.out.println(text);

			// ���ͻ��˻������ݡ�
			OutputStream out = s.getOutputStream();
			out.write("�ͻ��ˣ����ѵ��յ���ŶҮ��".getBytes());

			// �رտͻ���
			s.close();
		}
		// �رշ���ˡ�������ϵĻ�ȡ�ͻ��ˣ����ùرշ���ˡ�
//		ss.close();

	}

}
