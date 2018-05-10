package cn.itcast.io.d.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.itcast.domain.Person;

public class ObjectStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//需求：想要将封装了数据的对象进行持久化。当写入的对象很多对象会按照顺序排列，也称之为对象的序列化。
		//1,应该先有对象。Person name age。
		//2,往硬盘写数据，进行持久化，需要io技术。输出流。FileOutputStream。
		//3,在字节输出流中按照名称规律在api找到一个子类 ObjectOutputStream
		//4,在基础流对象上使用额外功能。
		
//		writeObj();
		
		
		
		//需求：读取已有的对象文件，并获取对象中的数据。
		//通过阅读ObjectOutputStream对象的文档，发现有一个对应的对象ObjectInputStream可以用于读区存储对象的文件
		//对象的反序列化。
		readObj();

	}

	public static void readObj() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("tempfile\\obj.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		System.out.println(obj.toString());
		
	}

	public static void writeObj() throws IOException {
		Person p = new Person("lisi",20);
		FileOutputStream fos = new FileOutputStream("tempfile\\obj.object");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p);
		
		oos.close();
		
	}

}
