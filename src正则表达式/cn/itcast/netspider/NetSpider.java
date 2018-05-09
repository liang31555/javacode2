package cn.itcast.netspider;

import java.io.BufferedReader;
import java.io.File;
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
		 * �������棺��ʵ����һ��Ӧ�ó��򣬻�ȡ�����е�ָ����Ϣ(����ָ���������Ϣ)��
		 * 
		 * �����е��ʼ���ַ��
		 * 
		 */
		File file = new File("tempfile\\mail.html");
		String regex = "\\w+@\\w+(\\.\\w+)+";
		
//		List<String> list = getMails(file,regex);
		String str_url = "http://bbs.tianya.cn/post-enterprise-401802-2.shtml";
		
		//http://tieba.baidu.com/p/2088202080 ��ѡ��
		
		List<String> list = getMailsByNet(str_url, regex);
		for(String mail : list){
			System.out.println("List:"+mail);
		}
	}
	//�������硣
	public static List<String> getMailsByNet(String str_url,String regex) throws IOException{
		
		List<String> list = new ArrayList<String>();
		
		//1,��str_url��װ��URL����
		URL url = new URL(str_url);
		
		//2,�����ӡ�
		URLConnection conn = url.openConnection();
		
		//3,��ȡ��ȡ����
		InputStream in = conn.getInputStream();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));
		
		//4,��������ʽ����ɶ���
		Pattern p = Pattern.compile(regex);
		
		String line = null;
		while((line=bufIn.readLine())!=null){
			
			Matcher m = p.matcher(line);
			
			while(m.find()){
				list.add(m.group());
				
			}
			
		}
		
		bufIn.close();
		
		return list;
	}
	
	//���ڱ����ļ���
	public static List<String> getMails(File file, String regex) throws IOException {
	
		
		List<String> list = new ArrayList<String>();
		//1,��ȡ�ļ�
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		
		//2,������������ɶ���
		Pattern p = Pattern.compile(regex);
		
		String line = null;
		while((line=bufr.readLine())!=null){
			
			Matcher m = p.matcher(line);
			
			while(m.find()){
				list.add(m.group());
			}
			
		}
		
		
		
		bufr.close();
		
		return list;
	}

}
