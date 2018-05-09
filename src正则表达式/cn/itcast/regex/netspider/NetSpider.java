package cn.itcast.regex.netspider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetSpider {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 网络爬虫：到网络中通过指定规则获取数据的程序。
		 * 
		 * 爬指定文件中的数据： 思路； 1，读取文件。 2，对读到的字符串进行规则匹配。只要符合规则就获取。
		 */
		// 定义规则。
		String regex = "\\w+@\\w+(\\.\\w+)+";// 1@1.1
		// List<String> list = getMailByLoacl(regex);
		List<String> list = getMailByNet(regex);
		for (String mail : list) {
			System.out.println(mail);
		}
	}

	public static List<String> getMailByNet(String regex) throws IOException {

		String str_url = "http://bbs.tianya.cn/post-enterprise-401802-5.shtml";
		// 1,将其封装成的URL对象。
		URL url = new URL(str_url);

		// 2,打开连接。
		URLConnection conn = url.openConnection();

		// 3,获取读取流。
		InputStream in = conn.getInputStream();

		// 4,读取操作。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(in));

		String line = null;

		// 获取功能。

		Pattern p = Pattern.compile(regex);

		List<String> list = new ArrayList<String>();

		while ((line = bufr.readLine()) != null) {

			// System.out.println(line);
			Matcher m = p.matcher(line);
			while (m.find()) {
				list.add(m.group());
			}
		}

		bufr.close();

		return list;

	}

	public static List<String> getMailByLoacl(String regex) throws IOException {
		// 1,读取文件。
		BufferedReader bufr = new BufferedReader(new FileReader("mail.html"));

		String line = null;

		// 获取功能。

		Pattern p = Pattern.compile(regex);

		List<String> list = new ArrayList<String>();

		while ((line = bufr.readLine()) != null) {

			// System.out.println(line);
			Matcher m = p.matcher(line);
			while (m.find()) {
				list.add(m.group());
			}
		}

		bufr.close();

		return list;
	}

}
