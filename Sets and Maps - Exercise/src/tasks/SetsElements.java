package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import javax.lang.model.element.Element;

public class SetsElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int n = inputs[0];
		int m = inputs[1];
		
		Set<Integer> firstSet = new LinkedHashSet<>();
		Set<Integer> secondSet = new LinkedHashSet<>();
		
		for (int i = 0; i < n; i++) {
			firstSet.add(Integer.parseInt(scanner.nextLine()));
		}
		
		for (int i = 0; i < m; i++) {
			secondSet.add(Integer.parseInt(scanner.nextLine()));
		}
		
		firstSet.retainAll(secondSet);
		firstSet.stream().forEach(element -> System.out.print(element + " "));
	}
}
