package tasks;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {
		File dir = new File("ListFiles/Files-and-Streams/");
		File[] files = dir.listFiles();

		for (File file : files) {
			if (!file.isDirectory()) {
				System.out.println(file.getName() + ": [" + file.length() + "]");
			}
		}

//		boolean isExist = file.exists();
//		System.out.println(isExist);
//
//		long length = file.length();
//		System.out.println(length);
//
//		boolean isDir = file.isDirectory();
//		System.out.println(isDir);

//		System.out.println(files);
	}

}
