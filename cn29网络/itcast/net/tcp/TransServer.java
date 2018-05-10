package cn.itcast.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("���������....");
		// ����ˣ�
		// ˼·��
		// 1�����������socket ��ȷ�˿ڡ�
		ServerSocket ss = new ServerSocket(10005);
		while (true) {
			// ��ȡ�ͻ��˶���
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress()+".....connected");

			// 2��Դ��socket����������ȡ�ͻ��˵ķ����������ݡ�
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(
					s.getInputStream()));

			// 3��Ŀ�ģ�socket���������ת�ɴ�д�����ݷ��͸��ͻ��ˡ�
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);

			// 4��Ƶ���Ķ�д������
			String line = null;
			while ((line = bufIn.readLine()) != null) {
				if("over".equals(line)){//����ͻ��˷���������over��ת��������
					break;
				}
				System.out.println(line);
				// ����ȡ������ĸ����ת�ɴ�д�����ظ��ͻ��ˡ�
				out.println(line.toUpperCase());
//				out.flush();
			}
			// 5���رտͻ��ˡ�
			s.close();
		}

	}

}
