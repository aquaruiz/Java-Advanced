package tasks;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
	public static void main(String[] args) {
		String path = "GetFolderSize";
		File dir = new File(path);

		ArrayDeque<File> dirs = new ArrayDeque<>();
		dirs.push(dir);

		long size = 0;

		while (!dirs.isEmpty()) {
			File current = dirs.pop();
			File[] currentDirs = current.listFiles();

			for (File file : currentDirs) {
				if (file.isDirectory()) {
					dirs.push(file);
				} else {
					size += file.length();
				}
			}
		}

		System.out.println("Folder size: " + size);
	}

}
