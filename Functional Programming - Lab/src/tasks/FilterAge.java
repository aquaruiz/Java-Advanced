package tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class FilterAge {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		Map<String, Integer> peopleAndAges = new LinkedHashMap<>();

		Function<String, Integer> parser = (x) -> Integer.parseInt(x);

		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(", ");
			String name = input[0];
			int age = parser.apply(input[1]);

			peopleAndAges.put(name, age);
		}

		String condition = scanner.nextLine();
		int conditionAge = Integer.parseInt(scanner.nextLine());
		String formatType = scanner.nextLine();

		BiPredicate<Map.Entry<String, Integer>, Integer> isYounger = (entry, age) -> entry.getValue() < age;

		BiPredicate<Map.Entry<String, Integer>, Integer> isOlder = (entry, age) -> entry.getValue() >= age;

		BiConsumer<Map.Entry<String, Integer>, String> printByCondition = (entry, key) -> {
			switch (key) {
			case "name":
				System.out.println(entry.getKey());
				break;
			case "age":
				System.out.println(entry.getValue());
				break;
			case "name age":
				System.out.println(entry.getKey() + " - " + entry.getValue());
				break;
			}
		};

		for (Map.Entry<String, Integer> person : peopleAndAges.entrySet()) {
			if (condition.equals("younger") && isYounger.test(person, conditionAge)) {
				printByCondition.accept(person, formatType);
			} else if (condition.equals("older") && isOlder.test(person, conditionAge)) {
				printByCondition.accept(person, formatType);
			}
		}
	}
}
