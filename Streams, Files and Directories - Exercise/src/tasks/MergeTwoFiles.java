package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {

	public static void main(String[] args) throws IOException {
		String inPath1 = "MergeTwoFiles/inputOne.txt";
		String inPath2 = "MergeTwoFiles/inputTwo.txt";
		String outPath = "MergeTwoFiles/output.txt";

		FileReader fr1 = new FileReader(inPath1);
		FileReader fr2 = new FileReader(inPath2);

		BufferedReader reader1 = new BufferedReader(fr1);
		BufferedReader reader2 = new BufferedReader(fr2);

		FileWriter fw = new FileWriter(outPath);
		PrintWriter writer = new PrintWriter(fw);

		String line = reader1.readLine();

		while (line != null) {
			writer.write(line + "\n");
			line = reader1.readLine();
		}

		line = reader2.readLine();

		while (line != null) {
			writer.write(line + "\n");
			line = reader2.readLine();
		}

		writer.flush();
	}

}
