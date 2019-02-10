package tasks;

import java.util.Scanner;

public class FillMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split(", ");
		int size = Integer.parseInt(input[0]);
		char typ = input[1].charAt(0);
		
		int[][] matrix = new int[size][size];

		switch (typ) {
		case 'A':
			// up down up down
			int counter = 1;
			for (int j = 0; j < size; j++) {
				for (int i = 0; i < size; i++) {
				matrix[i][j] = counter++;
				}
			}
			break;
		case 'B':
			// up down snake down up
			counter = 1;
			for (int j = 0; j < size; j++) {
				for (int i = 0; i < size; i++) {
					if (j % 2 == 0) {
						matrix[i][j] = counter++;
					} else {
						matrix[matrix.length - i - 1][j] = counter++;
					}
				}
			}
			break;

		default:
			System.out.println("Wrong input!");
			break;
		}
		
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
		
	}

}
