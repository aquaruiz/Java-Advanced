package tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteEveryThirdLine {

	public static void main(String[] args) throws IOException {
		String inPath = "WriteEvery3rdLine/input.txt";
		String outPath = "WriteEvery3rdLine/output.txt";

		FileInputStream inputStream;
		FileOutputStream outputStream;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inPath));
			PrintWriter writer = new PrintWriter(new FileWriter(outPath));
			int counter = 1;

			String nextLine = reader.readLine();

			while (nextLine != null) {
				if (counter % 3 == 0) {
					System.out.println(nextLine);
					writer.write(nextLine);
				}

				counter++;
				nextLine = reader.readLine();
			}

			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}