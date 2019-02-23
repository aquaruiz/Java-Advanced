package tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		Map<String, Map<String, Integer>> userIpDuration = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(" ");
			String ipAddress = input[0];
			String username = input[1];
			int duration = Integer.parseInt(input[2]);
			Map<String, Integer> ipDuration = new TreeMap<>();

			if (!userIpDuration.containsKey(username)) {
				ipDuration.put(ipAddress, duration);
				userIpDuration.put(username, ipDuration);
			} else {
				if (!userIpDuration.get(username).containsKey(ipAddress)) {
					userIpDuration.get(username).put(ipAddress, duration);
				} else {
					int newOne = duration + userIpDuration.get(username).get(ipAddress);
					userIpDuration.get(username).put(ipAddress, newOne);
				}
			}
		}

		List<String> output = new LinkedList<>();

		for (String user : userIpDuration.keySet()) {
			int totalTime = 0;
			for (Integer time : userIpDuration.get(user).values()) {
				totalTime += time;
			}
			System.out.print(user + ": " + totalTime + " [");

			System.out.print(String.join(", ", userIpDuration.get(user).keySet()));
			System.out.println("]");
		}
	}
}
