package cn.itcast.io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import cn.itcast.domain.Student;

public class Test4 {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		4，将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，
//		并将姓名和从高到低总分写入文件中。
		/*
		 * 思路：
		 * 1，描述学生。
		 * 2，既然要按照总分从高到低排序，学生多要存储集合，TreeSet。
		 * 3，将信息具体的信息保存到文件中。
		 * 		操作文件,持久化存储，涉及了IO技术。而且是将数据存储到文件中。所以写入。输出流。
		 * 
		 */
		Set<Student> set = new TreeSet<Student>(Collections.reverseOrder());
		
		set.add(new Student("李四",20,20,20));
		set.add(new Student("旺财",10,10,20));
		set.add(new Student("小明",60,30,70));
		set.add(new Student("小红",80,90,80));
		set.add(new Student("小强",20,70,20));
		
		File dir = new File("tempfile");
		if(!dir.exists()){
			dir.mkdir();
		}
		File destFile = new File(dir,"student_info.txt");
		write2File(set,destFile);
		
		
		
		
	}

	public static void write2File(Set<Student> set, File destFile) throws IOException {
		
		//1, 创建输出流对象和目的文件关联。并创建目的文件。OutputStream操作文件 FileOutputStream。
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(destFile);
			//2,遍历集合中的对象数据。将数据写入到指定文件中。
			
			for(Student stu : set){
				String info = stu.getName()+"\t"+stu.getSum()+LINE_SEPARATOR;
				//3,将数据写入到文件中。
				fos.write(info.getBytes());
			}
		}finally{
			if(fos!=null){
				
				//关闭资源。
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException("系统资源关闭失败");
				}
			}
		}
		
	}

}
