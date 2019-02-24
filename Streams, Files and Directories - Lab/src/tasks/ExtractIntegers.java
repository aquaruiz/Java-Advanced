package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

	public static void main(String[] args) throws IOException {
		String inPath = "ExtractIntegers/input.txt";
		String outPath = "ExtractIntegers/output.txt";

		FileInputStream inputStream;
		FileOutputStream outputStream;

		try {
			inputStream = new FileInputStream(inPath);
			Scanner scanner = new Scanner(inputStream);
			outputStream = new FileOutputStream(outPath);

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					String digits = String.valueOf(scanner.nextInt());

					for (int i = 0; i < digits.length(); i++) {
						outputStream.write(digits.charAt(i));
					}

					outputStream.write('\n');
				}

				scanner.next();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
