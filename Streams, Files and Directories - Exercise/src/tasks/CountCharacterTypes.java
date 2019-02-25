package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CountCharacterTypes {

	public static void main(String[] args) throws IOException {
		String path = "CountCharacterTypes/input.txt";
		String outPath = "CountCharacterTypes/output.txt";

		ArrayList<Character> vowels = new ArrayList<>();
		Collections.addAll(vowels, 'a', 'e', 'o', 'i', 'u');
		ArrayList<Character> punctuation = new ArrayList<>();
		Collections.addAll(punctuation, '.', ',', '!', '?');

		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);

		String line = reader.readLine();

		int vowelsCount = 0;
		int punctuationCount = 0;
		int consonantCount = 0;

		while (line != null) {
			for (Character ch : line.toCharArray()) {
				if (vowels.contains(ch)) {
					vowelsCount++;
				} else if (punctuation.contains(ch)) {
					punctuationCount++;
				} else {
					if (ch == ' ') {
						continue;
					} else {
						consonantCount++;
					}
				}
			}

			line = reader.readLine();
		}

		FileWriter fw = new FileWriter(outPath);
		PrintWriter writer = new PrintWriter(fw);

		writer.write("Vowels: " + vowelsCount);
		writer.write("\nConsonants: " + consonantCount);
		writer.write("\nPunctuation: " + punctuationCount);
		writer.flush();
	}
}