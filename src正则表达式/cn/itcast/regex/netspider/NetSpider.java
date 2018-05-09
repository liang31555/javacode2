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
		 * �������棺��������ͨ��ָ�������ȡ���ݵĳ���
		 * 
		 * ��ָ���ļ��е����ݣ� ˼·�� 1����ȡ�ļ��� 2���Զ������ַ������й���ƥ�䡣ֻҪ���Ϲ���ͻ�ȡ��
		 */
		// �������
		String regex = "\\w+@\\w+(\\.\\w+)+";// 1@1.1
		// List<String> list = getMailByLoacl(regex);
		List<String> list = getMailByNet(regex);
		for (String mail : list) {
			System.out.println(mail);
		}
	}

	public static List<String> getMailByNet(String regex) throws IOException {

		String str_url = "http://bbs.tianya.cn/post-enterprise-401802-5.shtml";
		// 1,�����װ�ɵ�URL����
		URL url = new URL(str_url);

		// 2,�����ӡ�
		URLConnection conn = url.openConnection();

		// 3,��ȡ��ȡ����
		InputStream in = conn.getInputStream();

		// 4,��ȡ������
		BufferedReader bufr = new BufferedReader(new InputStreamReader(in));

		String line = null;

		// ��ȡ���ܡ�

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
		// 1,��ȡ�ļ���
		BufferedReader bufr = new BufferedReader(new FileReader("mail.html"));

		String line = null;

		// ��ȡ���ܡ�

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
