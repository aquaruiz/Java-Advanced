package tasks;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Set<String> uniqueNames = new LinkedHashSet<>();
		
		int n = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < n; i++) {
			uniqueNames.add(scanner.nextLine());
		}
		
		uniqueNames.stream().forEach(System.out::println);
	}

}
