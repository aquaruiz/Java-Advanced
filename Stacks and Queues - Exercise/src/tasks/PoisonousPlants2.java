package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 87/100
public class PoisonousPlants2 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		scanner.nextLine();
		String[] p = Arrays.stream(scanner.nextLine().split(" "))
				.toArray(String[]::new);
		
		Long[] plants = Arrays.stream(p)
				.map(Long::parseLong)
				.toArray(Long[]::new);

		List<Long> survived = new ArrayList<Long>();
		Long deadPlantCount;
		Long day = 0L;
		
		do {
			deadPlantCount = 0L;
			survived.clear();
			day++;
			
			if (plants.length < 2) {
				break;
			}
			
			survived.add(plants[0]);
			
			for (int i = 0; i < plants.length - 1; i++) {
				if (plants[i + 1] > plants[i]) {
					deadPlantCount++;
				} else {
					survived.add(plants[i + 1]);
				}
			}
			
			plants = survived.stream().toArray(Long[]::new);
			survived.toArray(plants);
		} while (deadPlantCount > 0);

		System.out.println(day - 1);
	}
}
