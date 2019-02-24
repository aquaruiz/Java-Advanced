package task1OtherTry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// judge 75/100
		int maxCapacity = Integer.parseInt(scanner.nextLine());

		String[] input = scanner.nextLine().split(" ");
		ArrayDeque<String> inputStack = new ArrayDeque<>();
		Arrays.stream(input).forEach(element -> inputStack.push(element));

		ArrayDeque<String> halls = new ArrayDeque<>();

		String currentHall = "";
		int hallCapacity = maxCapacity;

		ArrayList<Integer> output = new ArrayList<>();
		currentHall = "";
		while (!inputStack.isEmpty()) {
			String popped = inputStack.pop();
			if (Character.isAlphabetic(popped.charAt(0))) {
				halls.offer(popped);
				break;
			}
		}

		currentHall = halls.removeFirst();

		while (!inputStack.isEmpty()) {
			String popped = inputStack.pop();
			if (Character.isAlphabetic(popped.charAt(0))) {
				halls.offer(popped);
			} else if (Character.isDigit(popped.charAt(0))) {

				int neededCapacity = Integer.parseInt(popped);

				hallCapacity -= neededCapacity;

				output.add(neededCapacity);

				if (hallCapacity < 0) {
					output.remove(output.size() - 1);
					inputStack.push(popped);
					System.out.print(currentHall + " -> ");
					for (int i = 0; i < output.size(); i++) {
						if (i == output.size() - 1) {
							System.out.printf("%d%n", output.get(i));
						} else {
							System.out.printf("%d, ", output.get(i));
						}
					}

					output.clear();

					if (halls.isEmpty()) {
						return;
					}

					currentHall = halls.poll();
					hallCapacity = maxCapacity;
				}
			}
		}
	}
}