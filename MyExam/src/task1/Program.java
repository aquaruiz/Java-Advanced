package task1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		60
//		judge 75/100
		int maxCapacity = Integer.parseInt(scanner.nextLine());

		String[] input = scanner.nextLine().split(" ");
		ArrayDeque<String> inputStack = new ArrayDeque<>();
		Arrays.stream(input).forEach(element -> inputStack.push(element));

		ArrayDeque<String> halls = new ArrayDeque<>();

		Map<String, List<Integer>> output = new LinkedHashMap<>();

		while (!inputStack.isEmpty()) {
			String popped = inputStack.pop();
			if (Character.isDigit(popped.charAt(0))) {
				continue;
			} else {
				output.put(popped, new LinkedList<Integer>());
				halls.offer(popped);
				break;
			}
		}

		int currentCapacity = maxCapacity;

		boolean overflowed = false;

		String currentHall = halls.removeFirst();
		while (!inputStack.isEmpty()) {
			String popped = inputStack.pop();

			if (Character.isDigit(popped.charAt(0))) {
				int neededCapacity = Integer.parseInt(popped);
				if (currentCapacity >= neededCapacity) {
					output.get(currentHall).add(neededCapacity);
					currentCapacity -= neededCapacity;
					overflowed = false;
				} else {
					overflowed = true;
					if (!halls.isEmpty()) {
						System.out.print(currentHall + " -> ");
						LinkedList<Integer> groups = (output.get(currentHall)).stream()
								.collect(Collectors.toCollection(LinkedList::new));

						for (int i = 0; i < groups.size(); i++) {
							if (i == groups.size() - 1) {
								System.out.printf("%d%n", groups.get(i));
							} else {
								System.out.printf("%d, ", groups.get(i));
							}
						}

						currentHall = halls.removeFirst();
						output.put(currentHall, new LinkedList<Integer>());
						inputStack.push(popped);
						currentCapacity = maxCapacity;
					} else {
						if (overflowed) {
							System.out.print(currentHall + " -> ");
							LinkedList<Integer> groups = (output.get(currentHall)).stream()
									.collect(Collectors.toCollection(LinkedList::new));

							for (int i = 0; i < groups.size(); i++) {
								if (i == groups.size() - 1) {
									System.out.printf("%d%n", groups.get(i));
								} else {
									System.out.printf("%d, ", groups.get(i));
								}
							}
						}
					}
				}
			} else {
				halls.offer(popped);
			}
		}
	}
}