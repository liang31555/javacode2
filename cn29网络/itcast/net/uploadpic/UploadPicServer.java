package cn.itcast.net.uploadpic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("�ϴ�ͼƬ���������......");
		// ����server  socket ��
		ServerSocket ss = new ServerSocket(10007);

		while (true) {
			// ��ȡ�ͻ��ˡ�
			Socket s = ss.accept();
			
			//ʵ�ֶ���ͻ��˲����ϴ����������˱������������߳�����ɡ�
			new Thread(new UploadPic(s)).start();
			
		}
	}

}
