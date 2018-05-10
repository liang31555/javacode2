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

			// 读取图片数据。
			InputStream in = s.getInputStream();

			// 写图片数据到文件。
			File dir = new File("e:\\uploadpic");
			if (!dir.exists()) {
				dir.mkdir();
			}
			// 为了避免覆盖，通过给重名的文件进行编号。
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

			// 给客户端一个回馈信息。
			OutputStream out = s.getOutputStream();
			out.write("上传成功".getBytes());

			// 关闭资源。
			fos.close();
			s.close();
		} catch (IOException e) {

		}

	}

}
