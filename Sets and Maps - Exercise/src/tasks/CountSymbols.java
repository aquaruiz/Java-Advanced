package tasks;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] inputLine = scanner.nextLine().toCharArray();

		Map<Character, Integer> letters = new TreeMap<>();
		
		for (int i = 0; i < inputLine.length; i++) {
			char currentChar = inputLine[i];
			
			if (!letters.containsKey(currentChar)) {
				letters.put(inputLine[i], 0);
			}
			
			letters.put(currentChar, letters.get(currentChar) + 1);
		}
		
		for (Character character : letters.keySet()) {
			System.out.println(character + ": " + letters.get(character) + " time/s");
		}
	}

}