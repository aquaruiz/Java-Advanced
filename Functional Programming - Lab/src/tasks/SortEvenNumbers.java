package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Integer> input = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList::new));

		Predicate<Integer> isNotEven = (n) -> n % 2 != 0;
		input.removeIf(isNotEven);

		System.out.println(input.stream().map(String::valueOf).collect(Collectors.joining(", ")));

		input.sort(Integer::compareTo);

		System.out.println(input.stream().map(String::valueOf).collect(Collectors.joining(", ")));
	}

}
