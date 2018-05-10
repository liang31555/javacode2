package cn.itcast.net.uploadpic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPicClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("上传图片客户端运行......");
		//1,创建socket。
		Socket s = new Socket("192.168.1.223", 10007);
		
		//2,读取源图片。
		File picFile = new File("tempfile\\1.jpg");
		FileInputStream fis = new FileInputStream(picFile);
		
		//3,目的是socket 输出流。
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//告诉服务器端图片数据发送完毕，不要等着读了。
		s.shutdownOutput();
		
		//读取上传成功字样。
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int lenIn = in.read(bufIn);
		System.out.println(new String(bufIn,0,lenIn));
		
		
		//关闭。
		fis.close();
		s.close();

	}

}
