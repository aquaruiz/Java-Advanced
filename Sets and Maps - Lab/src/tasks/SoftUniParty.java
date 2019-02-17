package tasks;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		Set<String> vips = new TreeSet<>();
		Set<String> reserves = new TreeSet<>();
		
		String input = scanner.nextLine();
		
		while (!input.equals("PARTY")) {
			if (Character.isDigit(input.charAt(0))) {
				vips.add(input);
			} else if(input.length() == 8) {
				reserves.add(input);
			}
			
			input = scanner.nextLine();
		}

		input = scanner.nextLine();
		while (!input.equals("END")) {
			if (vips.contains(input)) {
				vips.remove(input);
			} else if(reserves.contains(input)) {
				reserves.remove(input);
			}
			
			input = scanner.nextLine();
		}
		
		int rest = vips.size() + reserves.size();
		System.out.println(rest);
		
		for (String string : vips) {
			System.out.println(string);
		}
		
		for (String string : reserves) {
			System.out.println(string);
		}
	}
}