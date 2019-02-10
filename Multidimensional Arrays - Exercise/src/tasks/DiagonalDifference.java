package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			int[] input = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			matrix[i] = input;
		}
		
		int sumDiagonal1 = 0;
		int sumDiagonal2 = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			sumDiagonal1 += matrix[i][i];
			sumDiagonal2 += matrix[matrix.length - 1 - i][i];
		}
		
		System.out.println(Math.abs(sumDiagonal1 - sumDiagonal2));
	}
}