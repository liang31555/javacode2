package cn.itcast.reflect.test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class NoteBookMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * ����һ��
		 * 	�׶�һ���ʼǵ������С�NoteBook run();
		 * 	�׶ζ�����Ҫʹ��һЩ��Χ�豸��������꣬����......
		 * 			Ϊ������˱ʼǱ�����չ�ԣ�Ӧ�ý�����Щ�豸�ͱʼǱ�������ԡ�
		 * 			��Ҫ�ӿڡ�
		 * 			ֻ��Ҫ�����֮��������һ���ӿڡ����ұʼǱ���ʹ������ӿڡ�
		 * 
		 *	��������usb���豸����Ҫ���ϵ�new����ſ����á�ÿһ�ζ�Ҫ�޸Ĵ��롣
		 *
		 *	�ܲ��ܲ��޸�����롣�Ϳ���ʹ�ú��ڵ��豸�أ�
		 *	�豸����ȷ�ģ���ǰ�ڻ�Ҫ������ж���Ľ�������Ҫ���似����
		 *	�����ṩһ�������ļ���
		 */

		NoteBook book = new NoteBook();
		book.run();
//		book.useUSB(null);
//		book.useUSB(new MouseByUSB());
		
		//ͨ������ķ����������Ӧ�ó�������߸��õ���չ�ԡ�
		
		File configFile = new File("tempfile\\usb.properties");
		if(!configFile.exists()){
			configFile.createNewFile();
		}
	
		//2,��ȡ�����ļ���
		FileReader fr = new FileReader(configFile);
		
		//3,Ϊ�˻�ȡ���еļ�ֵ��Ϣ���㣬����Properties��
		Properties prop = new Properties();
		prop.load(fr);
		
		for(int x = 1; x<=prop.size(); x++){
			
			String className = prop.getProperty("usb"+x);
			//���䡣
			Class clazz = Class.forName(className);
			
			USB usb = (USB)clazz.newInstance();
			
			book.useUSB(usb);
			
		}
		
		
		fr.close();
	}

}
