package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int rows = Integer.parseInt(scanner.nextLine());
		int[][] matrix = new int[rows][];
		
		for (int i = 0; i < matrix.length; i++) {
			int[] input = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			matrix[i] = input;
		}
		
		int[] wrongValueCoodrinates = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		int wrongValue = matrix[wrongValueCoodrinates[0]][wrongValueCoodrinates[1]];
//		System.out.println(wrongValue);
		
		int[][] newMatrix = new int[rows][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == wrongValue) {
					int newValue = 0;
					if (j - 1 >= 0 && matrix[i][j - 1] != wrongValue) {
						newValue += matrix[i][j - 1];
					}
					
					if (j + 1 < matrix[i].length && matrix[i][j + 1] != wrongValue) {
						newValue += matrix[i][j + 1];
					}
					
					if (i - 1 >= 0 && matrix[i - 1][j] != wrongValue) {
						newValue += matrix[i - 1][j];
					}
					
					if (i + 1 < matrix.length && matrix[i + 1][j] != wrongValue) {
						newValue += matrix[i + 1][j];
					}
					
//					System.out.println(newValue);
					newMatrix[i][j] = newValue;
				} else {
					newMatrix[i][j] = matrix[i][j];
				}
			}
		}
		
		for (int[] arr : newMatrix) {
			for (int in : arr) {
				System.out.print(in + " ");
			}
			
			System.out.println();
		}
	}
}
