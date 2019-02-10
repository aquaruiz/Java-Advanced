package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int cmd = Integer.parseInt((scanner.nextLine().split("\\(")[1]).split("\\)")[0]) % 360;
//		System.out.println(cmd);
		
		List<String> matrix = new ArrayList<>();
		
		String input = scanner.nextLine();
		
		while (!input.equals("END")) {
			matrix.add(input);
			input = scanner.nextLine();
		}
		
		int rows = matrix.size();
		int cols = 0;
		
		for (String string : matrix) {
			int len = string.length();
			if (len > cols) {
				cols = len;
			}
		}
		
		String[][] rotateIt = new String[rows][cols];
		
		for (int i = 0; i < matrix.size(); i++) {
			String[] characters = matrix.get(i).split("");
			for (int j = 0; j < characters.length; j++) {
				rotateIt[i][j] = characters[j];
			}
			
		}
		
		switch (cmd) {
		case 0:
			for (String[] strings : rotateIt) {
				for (String ch : strings) {
					if (ch != null) {
						System.out.print(ch);
					}
				}
				
				System.out.println();
			}
			break;
		case 90:
		for (int j = 0; j < rotateIt[0].length; j++) {
			for (int i = rotateIt.length - 1; i >= 0; i--) {
					if (rotateIt[i][j] != null) {
						System.out.print(rotateIt[i][j]);
					} else {
						System.out.print(" ");
					}
				}
				
				System.out.println();
			}
			break;
		case 180:
			for (int i = rotateIt.length - 1; i >= 0; i--) {
				for (int j = rotateIt[i].length - 1; j >= 0; j--) {
					if (rotateIt[i][j] != null) {
						System.out.print(rotateIt[i][j]);
					} else {
						System.out.print(" ");
					}	
				}
				
				System.out.println();
			}
			break;
		case 270:
			for (int j = rotateIt[0].length - 1; j >= 0; j--) {
				for (int i = 0; i < rotateIt.length; i++) {
						if (rotateIt[i][j] != null) {
							System.out.print(rotateIt[i][j]);
						} else {
							System.out.print(" ");
						}
					}
					
					System.out.println();
				}
			break;
			
		default:
			break;
		}
	}
}
