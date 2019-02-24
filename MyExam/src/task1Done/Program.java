package task1Done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		ArrayDeque<String> input = new ArrayDeque<>();

		Arrays.stream(scanner.nextLine().split("\\s+")).forEach(input::push);
		LinkedHashMap<String, ArrayList<Integer>> halls = new LinkedHashMap<>();
		ArrayList<String> fullHalls = new ArrayList<>();

		for (String element : input) {
			if (Character.isDigit(element.charAt(0))) {
				int people = Integer.parseInt(element);

				for (String hall : halls.keySet()) {
					if (fullHalls.contains(hall)) {
						continue;
					}

					ArrayList<Integer> oldPeople = halls.get(hall);
					int sum = getSum(oldPeople);

					if (sum + people <= n) {
						oldPeople.add(people);
						halls.put(hall, oldPeople);
						break;
					} else {
						System.out.print(hall + " -> ");

						for (int i = 0; i < oldPeople.size(); i++) {
							if (i == oldPeople.size() - 1) {
								System.out.printf("%d", oldPeople.get(i));
							} else {
								System.out.printf("%d, ", oldPeople.get(i));
							}
						}

						System.out.println();
						fullHalls.add(hall);
					}
				}
			} else {
				halls.put(element, new ArrayList<>());
			}
		}
	}

	private static int getSum(ArrayList<Integer> integers) {
		int sum = 0;
		for (Integer integer : integers) {
			sum += integer;
		}

		return sum;
	}
}