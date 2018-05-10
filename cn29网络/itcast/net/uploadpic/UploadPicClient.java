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
		System.out.println("�ϴ�ͼƬ�ͻ�������......");
		//1,����socket��
		Socket s = new Socket("192.168.1.223", 10007);
		
		//2,��ȡԴͼƬ��
		File picFile = new File("tempfile\\1.jpg");
		FileInputStream fis = new FileInputStream(picFile);
		
		//3,Ŀ����socket �������
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//���߷�������ͼƬ���ݷ�����ϣ���Ҫ���Ŷ��ˡ�
		s.shutdownOutput();
		
		//��ȡ�ϴ��ɹ�������
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int lenIn = in.read(bufIn);
		System.out.println(new String(bufIn,0,lenIn));
		
		
		//�رա�
		fis.close();
		s.close();

	}

}
