﻿package cn.itcast.io.test;

import java.io.File;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 2，请删除一个带有内容的目录。
		/*
		 * 思路: 1，删除一个带有内容的目录原理；必须从里往外删。 2，到底有多级目录不确定，递归。
		 */
		File dir = new File("E:\\test");

		// System.out.println(dir.delete());

		removeDir(dir);

	}

	/**
	 * 删除一个目录。
	 */
	public static void removeDir(File dir) {

		// 1,列出当前目录下的文件以及文件夹File[]
		File[] files = dir.listFiles();//如果目录是系统级文件夹，java没有访问权限，那么会返回null数组。最好加入判断。
		if (files != null) {
			// if(files.length == 0){
			// dir.delete();
			// return;
			// }

			for (File file : files) {

				// 2,对遍历到的file对象判断是否是目录。
				if (file.isDirectory()) {
					removeDir(file);
				} else {
					System.out.println(file + ":" + file.delete());// 删除文件。用打印语句验证是否删除成功，是否出现了误删操作。
				}
			}
		}
		System.out.println(dir + ":" + dir.delete());

	}
}
