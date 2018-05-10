package cn.itcast.net.uploadtext;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		System.out.println("�ϴ��ı����������....");
		// ����ˣ�
		// ˼·��
		// 1�����������socket ��ȷ�˿ڡ�
		ServerSocket ss = new ServerSocket(10006);
		while (true) {
			// ��ȡ�ͻ��˶���
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress()+".....connected");

			// 2��Դ��socket����������ȡ�ͻ��˵ķ����������ݡ�
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(
					s.getInputStream()));

			// 3��Ŀ�ģ��ļ���
			PrintWriter pw = new PrintWriter(new FileWriter("tempfile\\server.txt"),true);

			// 4��Ƶ���Ķ�д������
			String line = null;
			while ((line = bufIn.readLine()) != null) {
//				if("over".equals(line)){
//					break;
//				}
				pw.println(line);
			}
			
			// 5�����ظ��ͻ����ϴ��ɹ�������
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			out.println("�ϴ��ɹ�");
			
			// 6���رտͻ��ˡ�
			s.close();
		}


	}

}
