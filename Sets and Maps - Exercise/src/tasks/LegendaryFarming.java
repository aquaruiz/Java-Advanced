package tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Integer> junk = new TreeMap<>();
		Map<String, Integer> possibelItems = new TreeMap<>();
		possibelItems.put("shards", 0);
		possibelItems.put("fragments", 0);
		possibelItems.put("motes", 0);

		String legendaryMaterial = "";
		boolean isOK = true;

		while (isOK) {
			LinkedList<String> curentRow = Arrays.stream(scanner.nextLine().toLowerCase().split(" "))
					.collect(Collectors.toCollection(LinkedList::new));
//todo
			for (int i = 0; i < curentRow.size(); i += 2) {
				int quantity = Integer.parseInt(curentRow.get(i));
				String material = curentRow.get(i + 1);

				if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {

					int newOne = quantity + possibelItems.get(material);
					possibelItems.put(material, newOne);
				} else {
					if (!junk.containsKey(material)) {
						junk.put(material, quantity);
					} else {
						int newOne = quantity + junk.get(material);
						junk.put(material, newOne);
					}
				}

				if (possibelItems.containsKey(material) && possibelItems.get(material) >= 250) {
					int newOne = possibelItems.get(material) - 250;
					possibelItems.put(material, newOne);
					legendaryMaterial = material;
					isOK = false;
					break;
				}
			}
		}

		switch (legendaryMaterial) {
		case "fragments":
			System.out.println("Valanyr obtained!");
			break;
		case "shards":
			System.out.println("Shadowmourne obtained!");
			break;
		case "motes":
			System.out.println("Dragonwrath obtained!");
			break;
		}

		LinkedList<Map.Entry<String, Integer>> listo = new LinkedList<>(possibelItems.entrySet());
		Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
		Collections.sort(listo, comparator.reversed());

		for (Map.Entry<String, Integer> item : listo) {
			System.out.printf("%s: %d%n", item.getKey(), item.getValue());
		}

		for (Map.Entry<String, Integer> mat : junk.entrySet()) {
			System.out.println(mat.getKey() + ": " + mat.getValue());
		}
	}
}