package tasks;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toCollection(LinkedHashSet::new));
		Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.distinct()
				.collect(Collectors.toCollection(LinkedHashSet::new));
		
		for (int i = 0; i < 50; i++) {
			int firstNumber = firstPlayer.iterator().next();
			firstPlayer.remove(firstNumber);
			int secondNumber = secondPlayer.iterator().next();
			secondPlayer.remove(secondNumber);
			
			if (firstNumber > secondNumber) {
				firstPlayer.add(firstNumber);
				firstPlayer.add(secondNumber);
			} else if (secondNumber > firstNumber) {
				secondPlayer.add(firstNumber);
				secondPlayer.add(secondNumber);
			}
			
			if (firstPlayer.size() == 0) {
				System.out.println("Second player won!");
				return;
			}
			
			if (secondPlayer.size() == 0) {
				System.out.println("First player won!");
				return;
			}
		}
		
		if (firstPlayer.size() > secondPlayer.size()) {
			System.out.println("First player win!");
		} else if(secondPlayer.size() > firstPlayer.size()) {
			System.out.println("Second player win!");
		} else {
			System.out.println("Draw!");
			
		}
	}
}