package tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		Map<String, String> mailList = new LinkedHashMap<>();

		while (!input.equals("stop")) {
			String name = input;
			String email = scanner.nextLine();

			if (!mailList.containsKey(name)) {
				if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
					mailList.put(name, email);
				}
			}

			input = scanner.nextLine();
		}

		for (String name : mailList.keySet()) {
			System.out.println(name + " -> " + mailList.get(name));
		}
	}
}
