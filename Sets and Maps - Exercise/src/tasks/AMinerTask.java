package tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Map<String, Long> mining = new LinkedHashMap<>();

		while (!input.equals("stop")) {
			String metal = input;
			long qnty = Long.parseLong(scanner.nextLine());

			if (!mining.containsKey(metal)) {
				mining.put(metal, qnty);
			} else {
				mining.put(metal, mining.get(metal) + qnty);
			}

			input = scanner.nextLine();
		}

		for (String metal : mining.keySet()) {
			System.out.println(metal + " -> " + mining.get(metal));
		}
	}
}