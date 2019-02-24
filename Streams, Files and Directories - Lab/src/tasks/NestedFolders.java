package tasks;

import java.io.File;

public class NestedFolders {

	public static void main(String[] args) {
		File dir = new File("NestedFolders/Files-and-Streams/");

		File[] files = dir.listFiles();

		int counter = 0;
		for (File file : files) {
			if (file.isDirectory()) {
				counter = printDir(file, counter);
			}
		}

		System.out.println(counter + " folders");
	}

	public static int printDir(File dir, int counter) {
		File[] files = dir.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
				printDir(file, counter++);
			}
		}

		return counter;
	}
}
