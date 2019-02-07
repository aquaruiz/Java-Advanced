package tasks;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersStack {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		ArrayDeque<Integer> stack = Arrays.stream(input.split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));
		
		while (!stack.isEmpty()) {
			int num = stack.pollLast();
			System.out.print(num + " ");
		}
	}

}
