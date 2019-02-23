package tasks;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DragonArmy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String, TreeMap<String, LinkedList<Double>>> dic = new LinkedHashMap<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			LinkedList<String> currentRow = Arrays.stream(scanner.nextLine().split(" "))
					.collect(Collectors.toCollection(LinkedList::new));

			String type = currentRow.get(0);
			String name = currentRow.get(1);

			if (currentRow.get(2).equals("null")) {
				currentRow.set(2, "45");
			}

			if (currentRow.get(3).equals("null")) {
				currentRow.set(3, "250");
			}
			if (currentRow.get(4).equals("null")) {
				currentRow.set(4, "10");
			}

			double damage = Double.parseDouble(currentRow.get(2));
			double health = Double.parseDouble(currentRow.get(3));
			double armor = Double.parseDouble(currentRow.get(4));

			if (!dic.containsKey(type)) {
				dic.put(type, new TreeMap<String, LinkedList<Double>>());
			}

			if (!dic.get(type).containsKey(name)) {
				dic.get(type).put(name, new LinkedList<Double>());
				dic.get(type).get(name).add(0.0);
				dic.get(type).get(name).add(0.0);
				dic.get(type).get(name).add(0.0);
			}

			dic.get(type).get(name).set(0, damage);
			dic.get(type).get(name).set(1, health);
			dic.get(type).get(name).set(2, armor);
		}

		for (String typ : dic.keySet()) {
			double[] totalStats = new double[3];

			for (String dragon : dic.get(typ).keySet()) {
				totalStats[0] += dic.get(typ).get(dragon).get(0);
				totalStats[1] += dic.get(typ).get(dragon).get(1);
				totalStats[2] += dic.get(typ).get(dragon).get(2);
			}

			for (int i = 0; i < totalStats.length; i++) {
				totalStats[i] /= dic.get(typ).size();
			}

			DecimalFormat dec = new DecimalFormat("0.00");

			System.out.println(typ + "::(" + dec.format(totalStats[0]) + "/" + dec.format(totalStats[1]) + "/"
					+ dec.format(totalStats[2]) + ")");

			for (String dragon : dic.get(typ).keySet()) {
				System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", dragon,
						dic.get(typ).get(dragon).get(0), dic.get(typ).get(dragon).get(1),
						dic.get(typ).get(dragon).get(2));
			}
		}
	}
}
