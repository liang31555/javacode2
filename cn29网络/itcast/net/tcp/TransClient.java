package cn.itcast.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TransClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("�ͻ�������......");
		// �ͻ��ˣ�
		// ���裺
		// 1������socket����ȷ��ַ�Ͷ˿ڡ�
		Socket s = new Socket("192.168.1.223", 10005);

		// 2��Դ������¼�롣��ȡ��Ҫת�������ݡ�
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		// 3��Ŀ�ģ����磬socket���������¼������ݷ��͵�����ˡ�
//		OutputStream out = s.getOutputStream();
		//��Ȼ�����ַ����ݣ�Ϊ�˱��ڲ�����ʹ�ö��⹦�ܣ�ת����ͬʱ���Ч�ʡ�
		//BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(out));����ʹ�ô�ӡ��
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		// 4��Դ��socket��socket��ȡ������ȡ����˷������Ĵ�д���ݡ�
//		InputStream in = s.getInputStream();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		// 5��Ŀ�ģ��ͻ�����ʾ��������д������ʾ������ֱ��ʹ�������䡣
		
		// 6��Ƶ���Ķ�д������
		String line = null;
		while((line=bufr.readLine())!=null){
			
			//����ȡ���̵����ݷ��͵�����ˡ�
			out.println(line);
//			out.flush();
			if("over".equals(line)){
				break;
			}
			
			//��ȡ����˷��ص����ݡ�
			String upperText = bufIn.readLine();
			System.out.println(upperText);
		}
		
		// 7���ر���Դ��
		s.close();
	}

}
