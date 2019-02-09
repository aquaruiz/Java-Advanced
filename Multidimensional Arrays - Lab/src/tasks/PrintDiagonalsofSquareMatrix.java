package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsofSquareMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int rowscols = Integer.parseInt(scanner.nextLine());
		
		int[][] matrix = new int[rowscols][rowscols];

		for (int i = 0; i < rowscols; i++) {
			matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					System.out.print(matrix[i][j] + " ");
				}
			}
		}
		
		System.out.println();
		
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix.length - i - 1 == j) {
					System.out.print(matrix[i][j] + " ");
				}
			}
		}
	}
}
