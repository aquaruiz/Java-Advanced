package tasks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CitiesContinentCountry {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		Map<String, Map<String, List<String>>> world = new LinkedHashMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(" ");
			String continent = input[0];
			String contry = input[1];
			String city = input[2];
			
			if (!world.containsKey(continent)) {
				world.put(continent, new LinkedHashMap<>());
			}
			
			if (!world.get(continent).containsKey(contry)) {
				world.get(continent).put(contry, new LinkedList<String>());
			}
			
			world.get(continent).get(contry).add(city);
		}
		
		for (String continent : world.keySet()) {
			System.out.println(continent + ":");
			
			for (String country : world.get(continent).keySet()) {
				System.out.printf("  %s -> %s", 
						country, 
						String.join(", ", world.get(continent).get(country)));
				System.out.println();
			}
			
		}
	}
}
