package tasks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOdds {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int lowerBound = input[0];
		int upperBound = input[1];

		String condition = scanner.nextLine();

		Predicate<Integer> isOdd = x -> x % 2 != 0;
		Predicate<Integer> isEven = x -> x % 2 == 0;

		Predicate<Integer> predicatreToUse = condition.equals("odd") ? isOdd : isEven;

		for (int i = lowerBound; i < upperBound + 1; i++) {
			if (predicatreToUse.test(i)) {
				System.out.print(i + " ");
			}
		}
	}

}
