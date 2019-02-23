package tasks;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		Set<String> elements = new TreeSet<>();
		
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(" ");
			
			for (int j = 0; j < input.length; j++) {
				String currentElement = input[j];
				elements.add(currentElement);
			}
		}
		
		System.out.println(String.join(" ", elements));
	}

}
