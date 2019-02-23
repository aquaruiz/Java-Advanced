package tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class srpskoUnleashed {

	public static void main(String[] args) {
		// Judge 90/100
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Integer>> srbsko = new LinkedHashMap<>();

		String inputLine = scanner.nextLine();

		while (!inputLine.equals("End")) {

			String[] inputParameters = inputLine.split("@");

			String currentSinger = inputParameters[0];
			if (!currentSinger.endsWith(" ")) {
				inputLine = scanner.nextLine();
				continue;
			}

			currentSinger = inputParameters[0].substring(0, inputParameters[0].length() - 1);
			String venuePriceCountPair = inputParameters[1];
			LinkedList<String> venueAndOtherParameters = Arrays.stream(venuePriceCountPair.split(" "))
					.collect(Collectors.toCollection(LinkedList::new));

			try {
				int currentTicketsCount = Integer
						.parseInt(venueAndOtherParameters.get(venueAndOtherParameters.size() - 1));

				try {
					int currentTicketPrice = Integer
							.parseInt(venueAndOtherParameters.get(venueAndOtherParameters.size() - 2));
					venueAndOtherParameters.remove(venueAndOtherParameters.size() - 1);
					venueAndOtherParameters.remove(venueAndOtherParameters.size() - 1);

					String currentPlace = String.join(" ", venueAndOtherParameters);
					int currentIncomeMoney = currentTicketPrice * currentTicketsCount;

					if (!srbsko.containsKey(currentPlace)) {
						srbsko.put(currentPlace, new LinkedHashMap<String, Integer>());
					}

					if (!srbsko.get(currentPlace).containsKey(currentSinger)) {
						srbsko.get(currentPlace).put(currentSinger, 0);
					}

					int income = currentIncomeMoney + srbsko.get(currentPlace).get(currentSinger);
					srbsko.get(currentPlace).put(currentSinger, income);
				} catch (Exception e) {
					inputLine = scanner.nextLine();
				}
			} catch (Exception e) {
				inputLine = scanner.nextLine();
			}

			inputLine = scanner.nextLine();
		}

		for (String place : srbsko.keySet()) {
			System.out.println(place);

			LinkedList<Map.Entry<String, Integer>> orderedSingerMoney = new LinkedList<>(srbsko.get(place).entrySet());
			Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
			Collections.sort(orderedSingerMoney, comparator.reversed());

			for (Map.Entry<String, Integer> singerMoney : orderedSingerMoney) {
				System.out.println("#  " + singerMoney.getKey() + " -> " + singerMoney.getValue());
			}
		}
	}
}