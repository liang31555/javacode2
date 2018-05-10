package cn.itcast.io.b.mergefile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MergeFileTest2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 合并碎片文件。
		/*
		 * 思路: 1，碎片文件有很多，每一个碎片都需要和读取流关联。 2，每一个读取流读取到的数据都需要通过一个输出流写入到一个文件中。
		 * 3，原理：多个源--->一个目的地。
		 * 
		 * 
		 * 如下代码的问题： 碎片过多，会产生很多的输入流对象，这是正常的，不正常在于，面对每一个输入流对象去操作。
		 * 当流对象过多时，必须先存储起来。面的流对象的容器操作更容易。 1，需要容器。 2，将流对象和碎片文件关联后存储到容器中。
		 * 3，遍历容器获取其中的流对象，在进行频繁的读写操作。 4，即使关流也是遍历容器对每一个流对象进行close的调用。
		 * 参阅MergeFileTest2.java
		 */

		List<FileInputStream> list = new ArrayList<FileInputStream>();

		for (int i = 1; i < 7; i++) {
			list.add(new FileInputStream("E:\\PartFiles\\" + i + ".part"));
		}

		FileOutputStream fos = new FileOutputStream("E:\\PartFiles\\00.mp3");

		byte[] buf = new byte[1024 * 1024];
		// 遍历集合，获取流对象。
		for (FileInputStream fis : list) {

			int len = fis.read(buf);
			fos.write(buf, 0, len);
		}

		fos.close();
		// 关闭所有流对象。
		for (FileInputStream fis : list) {

			fis.close();
		}
	}

}
/*
class MyMergeStream{
	MyMergeStream(List<? extends InputStream> list){
		
	}
	
	public void close(){
		for (InputStream fis : list) {

			fis.close();
		}
	}
}
*/