package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

	public static void main(String[] args) throws IOException {
		String inPath = "CopyBytes/input.txt";
		String outPath = "CopyBytes/output.txt";

		FileInputStream inputStream;
		FileOutputStream outputStream;

		try {
			inputStream = new FileInputStream(inPath);
			outputStream = new FileOutputStream(outPath);

			int oneByte = inputStream.read();

			while (oneByte >= 0) {
				System.out.println(oneByte);
				if (oneByte == ' ' || oneByte == '\n') {
					outputStream.write(oneByte);
				} else {
					String digits = String.valueOf(oneByte);
					for (int i = 0; i < digits.length(); i++) {
				    	outputStream.write(digits.charAt(i));
	  				}
				}

				oneByte = inputStream.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
