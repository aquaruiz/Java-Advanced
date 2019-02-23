package tasks;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PopulationCounter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		Map<String, Map<String, Long>> populationByCityCountry = new LinkedHashMap<>();
		Map<String, Long> populationTotalByCountry = new LinkedHashMap<>();

		while (!input.equals("report")) {
			String[] statistics = input.split("\\|");
			String city = statistics[0];
			String country = statistics[1];
			long population = Long.parseLong(statistics[2]);

			Map<String, Long> cityPopulation = new LinkedHashMap<>();

			if (!populationByCityCountry.containsKey(country)) {
				cityPopulation.put(city, population);
				populationByCityCountry.put(country, cityPopulation);
				populationTotalByCountry.put(country, population);
			} else {
				populationTotalByCountry.put(country, populationTotalByCountry.get(country) + population);

				if (!populationByCityCountry.get(country).containsKey(city)) {
					populationByCityCountry.get(country).put(city, population);
				} else {
					long newOne = population + populationByCityCountry.get(country).get(city);
					populationByCityCountry.get(country).put(city, newOne);
				}
			}

			input = scanner.nextLine();
		}

		LinkedList<Map.Entry<String, Long>> listo = new LinkedList<>(populationTotalByCountry.entrySet());
		Comparator<Map.Entry<String, Long>> comparator = Comparator.comparing(Map.Entry::getValue);
		Collections.sort(listo, comparator.reversed());

		for (Entry<String, Long> country : listo) {
			System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());

			LinkedList<Map.Entry<String, Long>> cities = new LinkedList<>(
					populationByCityCountry.get(country.getKey()).entrySet());
			Collections.sort(cities, comparator.reversed());

			for (Entry<String, Long> city : cities) {
				System.out.println("=>" + city.getKey() + ": " + city.getValue());
			}
		}
	}
}