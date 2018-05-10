package cn.itcast.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("����˿���.....");

		/*
		 * ���󣺻�ȡ�ͻ��˵����ݲ���ʾ����Ļ�ϡ� ˼·�� 1����������˵�socket����ȷ�˿ڣ�����һ���˿ڡ�
		 * 2�������ֻҪ��ȡ�����ӹ����Ŀͻ��˾Ϳ��Ժ�ָ���Ŀͻ���ͨ���ˡ� 3��ͨ����ȡ�ͻ��˵Ķ�ȡ�������ȡ�ͻ��˷��������ݡ� 4������ʾ��Ļ�ϡ�
		 */

		// 1����������˵�socket����ȷ�˿ڣ�����һ���˿ڡ�
		ServerSocket ss = new ServerSocket(10003);

		while (true) {
			// 2�������ֻҪ��ȡ�����ӹ����Ŀͻ��˾Ϳ��Ժ�ָ���Ŀͻ���ͨ���ˡ�
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip + ".....connected");
			// 3��ͨ����ȡ�ͻ��˵Ķ�ȡ�������ȡ�ͻ��˷��������ݡ�
			InputStream in = s.getInputStream();

			// 4������ʾ��Ļ�ϡ�
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String text = new String(buf, 0, len);
			System.out.println(text);

			// 5,�ر���Դ��
			s.close();

		}
		// ss.close();
	}

}
