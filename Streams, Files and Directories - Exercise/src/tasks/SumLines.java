package tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

	public static void main(String[] args) throws IOException {
		String inPath = "SumLines/input.txt";

		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			int sum = 0;
			while (line != null) {
				for (char string : line.toCharArray()) {
					sum += Integer.valueOf(string);
				}

				System.out.println(sum);
				sum = 0;

				line = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}