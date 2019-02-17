package tasks;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Set<String> parking = new HashSet<>();
		String input = scanner.nextLine();
		
		while (!input.equals("END")){
			String[] tokens = input.split(", ");
			String plates = tokens[1];
			
			switch (tokens[0]) {
			case "IN":
				parking.add(plates);
				break;
			case "OUT":
				parking.remove(plates);
				break;

			default:
				break;
			}
			input = scanner.nextLine();
		}
		
		if (parking.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		} else {
			for (String string : parking) {
				System.out.println(string);
			}
		}
	}

}
