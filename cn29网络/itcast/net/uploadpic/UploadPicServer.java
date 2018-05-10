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
		System.out.println("上传图片服务端运行......");
		// 创建server  socket 。
		ServerSocket ss = new ServerSocket(10007);

		while (true) {
			// 获取客户端。
			Socket s = ss.accept();
			
			//实现多个客户端并发上传，服务器端必须启动做个线程来完成。
			new Thread(new UploadPic(s)).start();
			
		}
	}

}
