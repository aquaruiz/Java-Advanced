package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {

	public static void main(String[] args) throws IOException {
		String inPart1 = "WordCount/words.txt";
		String inPart2 = "WordCount/text.txt";
		String outPath = "WordCount/results.txt";

		FileReader fr1 = new FileReader(inPart1);
		FileReader fr2 = new FileReader(inPart2);
		FileWriter fw = new FileWriter(outPath);

		BufferedReader readerFile1 = new BufferedReader(fr1);
		BufferedReader readerFile2 = new BufferedReader(fr2);
		PrintWriter writer = new PrintWriter(fw);

		Map<String, Integer> countStrings = new LinkedHashMap<>();

		String line1 = readerFile1.readLine();
		String line2 = readerFile2.readLine();

		String[] toSearchFor = line1.split(" ");

		System.out.println(line1);
		System.out.println(line2);

		while (line2 != null) {
			for (String string2 : line2.split(" ")) {
				for (String string1 : toSearchFor) {
					if (string1.equals(string2)) {
						System.out.println(string1);
						if (!countStrings.containsKey(string1)) {
							countStrings.put(string1, 0);
						}

						int newOne = countStrings.get(string1) + 1;
						countStrings.put(string1, newOne);
					}
				}
			}

			line2 = readerFile2.readLine();
		}

		for (String string : countStrings.keySet()) {
			writer.write(string + " - " + countStrings.get(string) + "\n");
		}

		writer.flush();
	}
}