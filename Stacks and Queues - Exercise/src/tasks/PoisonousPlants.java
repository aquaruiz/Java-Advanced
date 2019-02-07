package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 25/100 12/100

public class PoisonousPlants {

	public static void main(String[] args) {
//		System.out.println(10000000000L>999999999L);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		long plantsN = Long.parseLong(scanner.nextLine());
		long[] plants = Arrays.stream(scanner.nextLine().split(" "))
				.mapToLong(Long::parseLong)
				.toArray();
		List<Long> plantsList = new ArrayList<Long>();

		List<Long> leftPlants = new ArrayList<>();
		for (Long num : plants) {
			plantsList.add(num);
		}
		
		// 6 5 8 4 7 10 9
		
		long days = 1;
		
		Boolean isSomeDead = false;
		leftPlants.add(plantsList.get(0));
		
		for (int i = 1; i < plantsList.size(); i++) {
			if (plantsList.get(i) > plantsList.get(i - 1)) {
//				plantsList.remove(i);
				isSomeDead = true;
			} else {
				leftPlants.add(plantsList.get(i));
			}
		}
		
		plantsList = new ArrayList<>(leftPlants);
		leftPlants.clear();
		
		while (isSomeDead && plantsList.size() > 1) {
			days++;
			leftPlants.add(plantsList.get(0));
//			for (int i = 1; i < plantsList.size(); i++) {
//				isSomeDead = false;
//				if (plantsList.get(i) > plantsList.get(i - 1)) {
//					plantsList.remove(i);
//					i--;
//					isSomeDead = true;
//				}
//			}

			for (int i = 1; i < plantsList.size(); i++) {
				isSomeDead = false;
				if (plantsList.get(i) > plantsList.get(i - 1)) {
					isSomeDead = true;
				} else {
					leftPlants.add(plantsList.get(i));
				}
			}
			
			plantsList = new ArrayList<>(leftPlants);
			leftPlants.clear();
		}
		
		System.out.println(days);
	}
}
