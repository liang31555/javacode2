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
		 * ip地址对象。InetAddress
		 */
		
		//获取本地主机地址对象。
//		InetAddress ip = InetAddress.getLocalHost();
		//获取其他主机的地址对象。
		InetAddress ip = InetAddress.getByName("www.sina.com.cn");
		System.out.println(ip.getHostAddress()+":"+ip.getHostName());
	}
}
