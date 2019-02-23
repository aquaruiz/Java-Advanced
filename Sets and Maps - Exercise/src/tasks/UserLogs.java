package tasks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		Map<String, Map<String, Integer>> userIpLogs = new TreeMap<>();

		while (!input.equals("end")) {
			String[] command = input.split(" ");
			String ipAddress = command[0].split("=")[1];
			String username = command[2].split("=")[1];
			Map<String, Integer> ipLogQnty = new LinkedHashMap<>();

			if (!userIpLogs.containsKey(username)) {
				ipLogQnty.put(ipAddress, 1);
				userIpLogs.put(username, ipLogQnty);
			} else {
				if (!userIpLogs.get(username).containsKey(ipAddress)) {
					userIpLogs.get(username).put(ipAddress, 1);
				} else {
					userIpLogs.get(username).put(ipAddress, userIpLogs.get(username).get(ipAddress) + 1);
				}
			}

			input = scanner.nextLine();
		}

		List<String> output = new LinkedList<String>();

		for (String userIP : userIpLogs.keySet()) {
			System.out.println(userIP + ":");

			for (String entry : userIpLogs.get(userIP).keySet()) {
				output.add(String.format("%s => %s", entry, userIpLogs.get(userIP).get(entry)));
			}

			for (int i = 0; i < output.size(); i++) {
				if (i == output.size() - 1) {
					System.out.println(output.get(i) + ".");
				} else {
					System.out.println(output.get(i) + ",");

				}
			}
			output.clear();
		}
	}
}