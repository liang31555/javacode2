package cn.itcast.net.uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPic implements Runnable {

	private Socket s;

	public UploadPic(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {

		try {
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip + ".....connected");

			// ��ȡͼƬ���ݡ�
			InputStream in = s.getInputStream();

			// дͼƬ���ݵ��ļ���
			File dir = new File("e:\\uploadpic");
			if (!dir.exists()) {
				dir.mkdir();
			}
			// Ϊ�˱��⸲�ǣ�ͨ�����������ļ����б�š�
			int count = 1;
			File picFile = new File(dir, ip + "(" + count + ").jpg");
			while (picFile.exists()) {
				count++;
				picFile = new File(dir, ip + "(" + count + ").jpg");
			}
			FileOutputStream fos = new FileOutputStream(picFile);

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			// ���ͻ���һ��������Ϣ��
			OutputStream out = s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());

			// �ر���Դ��
			fos.close();
			s.close();
		} catch (IOException e) {

		}

	}

}
