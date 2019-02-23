package tasks;

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

		for (String dragon : dic.keySet()) {
			System.out.println(dragon);

			// TODO print!
//            double averageDamage = dragonData.Value.Select(x => x.Value[0]).Average();
//            double averageHealths = dragonData.Value.Select(x => x.Value[1]).Average();
//            double averageArmor = dragonData.Value.Select(x => x.Value[2]).Average();
//
//            Console.WriteLine($"{dragonData.Key}::({averageDamage:f2}/{averageHealths:f2}/{averageArmor:f2})");
//            foreach (var currentDragon in dragonData.Value)
//            {
//                Console.WriteLine("-{0} -> damage: {1}, health: {2}, armor: {3}",
//                    currentDragon.Key,
//                    currentDragon.Value[0],
//                    currentDragon.Value[1],
//                    currentDragon.Value[2]
//                );
//            }
		}
	}
}
