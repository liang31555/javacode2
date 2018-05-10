package cn.itcast.io.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test5 {

	private static final String LINE_SEPARATOR = SeparatorTool.LINE_SEPARATOR;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		5，获取指定目录下所有的.java文件(包含子目录中的)，
//		并将这些java文件的绝路路径写入到一个文件中。
//		建立一个java文件清单列表。
		/*
		 * 思路：
		 * 1，一看到包含子目录，必须递归。
		 * 2，写数据到文件，输出流。
		 * 3，继续分析，发现只要.java ，需要过滤器。
		 * 4，满足过滤的条件的文件有可能非常多，先进行存储。
		 */
		//被遍历的目录。
		File dir = new File("E:\\Java_Code");
		
		//明确一个过滤器。
		FileFilter filter = new FileFilterBySuffix(".java");
		
		
		//符合过滤器条件的文件有很多，最好先存储起来，然后在进行操作。
		List<File> list = new ArrayList<File>();
		//获取指定文件清单。
		getFileList(dir,filter,list);
//		System.out.println(list.size());
		
		File destFile = new File(dir,"javalist.txt");
		write2File(list,destFile);
	}

	/**
	 * 将集合中的数据的绝对路径写入到文件中。
	 * @param list
	 * @param destFile
	 * @throws IOException 
	 */
	public static void write2File(List<File> list, File destFile) throws IOException {
		FileOutputStream fos = null;
		BufferedOutputStream bufos = null;
		try{
			fos = new FileOutputStream(destFile);
			bufos = new BufferedOutputStream(fos);
			
			for(File file : list){
				String info = file.getAbsolutePath()+LINE_SEPARATOR;
				bufos.write(info.getBytes());
				bufos.flush();//每写一个绝对路径就刷新一次。
			}
		}finally{
			if(bufos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
		
	}

	/**
	 * 根据指定的过滤器在指定目录下获取所有的符合过滤条件的文件，并存储到list集合中。
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void getFileList(File dir,FileFilter filter,List<File> list) {
		
		File[] files = dir.listFiles();
		
		for(File file : files){
			
			if(file.isDirectory()){
				getFileList(file,filter,list);
			}else{
				//如果是文件，传递到过滤器中去过滤。将满足条件存储起来。
				if(filter.accept(file)){
					list.add(file);
				}
			}
		}
		
	}
	
	
}
