package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCAPITALS {

	public static void main(String[] args) throws IOException {
		String inPath = "ALLCAPITALS/input.txt";
		String outPath = "ALLCAPITALS/output.txt";

		FileReader fr = new FileReader(inPath);
		BufferedReader reader = new BufferedReader(fr);

		FileWriter fw = new FileWriter(outPath);
		PrintWriter writer = new PrintWriter(fw);

		String line = reader.readLine();

		while (line != null) {
			String newLine = line.toUpperCase();
			System.out.println(newLine);
			writer.write(newLine);

			line = reader.readLine();
		}

		writer.flush();
	}
}