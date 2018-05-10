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
		 * 案例一：
		 * 	阶段一：笔记电脑运行。NoteBook run();
		 * 	阶段二：想要使用一些外围设备，比如鼠标，键盘......
		 * 			为了提高了笔记本的扩展性，应该降低这些设备和笔记本的耦合性。
		 * 			需要接口。
		 * 			只需要在设计之初，定义一个接口。而且笔记本在使用这个接口。
		 * 
		 *	后期有了usb的设备后，需要不断的new对象才可以用。每一次都要修改代码。
		 *
		 *	能不能不修改这代码。就可以使用后期的设备呢？
		 *	设备不明确的，而前期还要对其进行对象的建立。需要反射技术。
		 *	对外提供一个配置文件。
		 */

		NoteBook book = new NoteBook();
		book.run();
//		book.useUSB(null);
//		book.useUSB(new MouseByUSB());
		
		//通过反射的方法重新设计应用程序，以提高更好的扩展性。
		
		File configFile = new File("tempfile\\usb.properties");
		if(!configFile.exists()){
			configFile.createNewFile();
		}
	
		//2,读取配置文件。
		FileReader fr = new FileReader(configFile);
		
		//3,为了获取其中的键值信息方便，建立Properties。
		Properties prop = new Properties();
		prop.load(fr);
		
		for(int x = 1; x<=prop.size(); x++){
			
			String className = prop.getProperty("usb"+x);
			//反射。
			Class clazz = Class.forName(className);
			
			USB usb = (USB)clazz.newInstance();
			
			book.useUSB(usb);
			
		}
		
		
		fr.close();
	}

}
