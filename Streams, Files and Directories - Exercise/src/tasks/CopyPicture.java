package tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyPicture {

	public static void main(String[] args) throws IOException {
		String path = "CopyPicture/pic.jpg";
		String outPath = "CopyPicture/out.txt";
		String pathToWrite = "CopyPicture/out2.txt";
		String pathToWrite2 = "CopyPicture/pic-copy.jpg";

		FileReader fr1 = new FileReader(path);
		BufferedReader reader1 = new BufferedReader(fr1);

		FileWriter fw = new FileWriter(outPath);
		@SuppressWarnings("resource")
		PrintWriter writer = new PrintWriter(fw);

		String line = reader1.readLine();

		while (line != null) {
			writer.write(line + "\n");
			line = reader1.readLine();
		}

		writer.flush();

		FileInputStream fileStream;
		FileOutputStream fileOut;
//
//		try {
//			fileStream = new FileInputStream(path);
//			fileOut = new FileOutputStream(pathToWrite);
//			int oneByte = fileStream.read();
//
//			while (oneByte >= 0) {
//				fileOut.write(oneByte);
//				oneByte = fileStream.read();
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			fileStream = new FileInputStream(path);
			fileOut = new FileOutputStream(pathToWrite2);
			int oneByte = fileStream.read();

			while (oneByte >= 0) {
				fileOut.write(oneByte);
				oneByte = fileStream.read();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
