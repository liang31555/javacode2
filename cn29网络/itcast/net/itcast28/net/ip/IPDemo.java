package cn.itcast.net.ip;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * ip��ַ����InetAddress
		 */
		
		//��ȡ����������ַ����
//		InetAddress ip = InetAddress.getLocalHost();
		//��ȡ���������ĵ�ַ����
		InetAddress ip = InetAddress.getByName("www.sina.com.cn");
		System.out.println(ip.getHostAddress()+":"+ip.getHostName());
	}
}
