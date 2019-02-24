package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {

	public static void main(String[] args) throws IOException {
		String path = "writeFile/input.txt";
		String pathToWrite = "writeFile/output.txt";

		FileInputStream fileStream;
		FileOutputStream fileOut;

		List<Character> punctuation = new ArrayList<>();
		Collections.addAll(punctuation, '.', ',', '!', '?');

		try {
			fileStream = new FileInputStream(path);
			fileOut = new FileOutputStream(pathToWrite);
			int oneByte = fileStream.read();

			while (oneByte >= 0) {
				if (!punctuation.contains((char) oneByte)) {
					fileOut.write((char) oneByte);
					System.out.print((char) oneByte + "");
				}

				oneByte = fileStream.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
