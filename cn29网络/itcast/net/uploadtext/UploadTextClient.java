package cn.itcast.net.uploadtext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadTextClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ϴ��ļ��ͻ�������......");
		// �ͻ��ˣ�
		// ���裺
		// 1������socket����ȷ��ַ�Ͷ˿ڡ�
		Socket s = new Socket("192.168.1.223", 10006);

		// 2��Դ����ȡ�ı��ļ�����ȡ��Ҫת�������ݡ�
		BufferedReader bufr = new BufferedReader(new FileReader("tempfile\\client.txt"));
		
		// 3��Ŀ�ģ����磬socket���������¼������ݷ��͵�����ˡ�
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		// 4��Ƶ���Ķ�д������
		String line = null;
		while((line=bufr.readLine())!=null){
			
			out.println(line);
			
		}
		
		//������˷���һ��������ǡ���������Լ����ǡ��е��鷳�����Ը��򵥡�ʹ��socket�����shutdownOutput();
//		out.println("over");
		s.shutdownOutput();//�����˷����˽�����ǡ������÷���˽�����ȡ�Ķ�����
		
		
		// 5��Դ��socket��socket��ȡ������ȡ����˷��������ϴ��ɹ���Ϣ��
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String info = bufIn.readLine();
		System.out.println(info);
		
		// 6���ر���Դ��
		bufr.close();
		s.close();


	}

}
