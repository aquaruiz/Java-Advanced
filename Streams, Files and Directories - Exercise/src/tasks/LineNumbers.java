package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {

	public static void main(String[] args) throws IOException {
		String inPath = "LineNumbers/inputLineNumbers.txt";
		String outPath = "LineNumbers/output.txt";

		FileReader fr = new FileReader(inPath);
		BufferedReader reader = new BufferedReader(fr);

		FileWriter fw = new FileWriter(outPath);
		PrintWriter writer = new PrintWriter(fw);

		int counter = 0;
		String line = reader.readLine();

		while (line != null) {
			counter++;
			writer.write(counter + ". " + line + "\n");
			line = reader.readLine();
		}

		writer.flush();
	}
}