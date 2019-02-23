package tasks;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HandsCards {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Map<String, LinkedHashSet<String>> drawCardsByPerson = new LinkedHashMap<>();

		while (!input.equals("JOKER")) {
			String[] draw = input.split(": ");
			String player = draw[0];
			LinkedHashSet<String> drawnCards = Arrays.stream(draw[1].split(", "))
					.collect(Collectors.toCollection(LinkedHashSet::new));

			if (!drawCardsByPerson.containsKey(player)) {
				drawCardsByPerson.put(player, new LinkedHashSet<String>());
			}

			drawCardsByPerson.get(player).addAll(drawnCards);

			input = scanner.nextLine();
		}

		int playerCardsSum = 0;

		for (String player : drawCardsByPerson.keySet()) {
			for (String card : drawCardsByPerson.get(player)) {
				char cardColor = card.charAt(card.length() - 1);
				String cardValue = card.substring(0, card.length() - 1);
				int colorPoints = 0;
				int valuePoints = 0;

				switch (cardColor) {
				case 'S':
					colorPoints = 4;
					break;
				case 'H':
					colorPoints = 3;
					break;
				case 'D':
					colorPoints = 2;
					break;
				case 'C':
					colorPoints = 1;
					break;
				}

				switch (cardValue) {
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "10":
					valuePoints = Integer.parseInt(cardValue);
					break;
				case "J":
					valuePoints = 11;
					break;
				case "Q":
					valuePoints = 12;
					break;
				case "K":
					valuePoints = 13;
					break;
				case "A":
					valuePoints = 14;
					break;
				}

				playerCardsSum += colorPoints * valuePoints;
			}

			System.out.println(player + ": " + playerCardsSum);
			playerCardsSum = 0;
		}
	}
}