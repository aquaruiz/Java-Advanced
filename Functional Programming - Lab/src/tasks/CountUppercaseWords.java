package tasks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		Predicate<String> isUpperCased = (x) -> Character.toUpperCase(x.charAt(0)) == x.charAt(0);

		ArrayList<String> output = new ArrayList<>();
		int count = 0;

		for (String string : line.split(" ")) {
			if (isUpperCased.test(string)) {
				count++;
				output.add(string);
			}
		}

		System.out.println(count);
		System.out.println(output.stream().collect(Collectors.joining("\n")));
	}
}
